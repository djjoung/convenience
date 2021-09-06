# convenience



--------  AWS 환경 설정 값 ---------
리전코드     : ca-central-1
사용자 계정  : user-dongjin
클러스터     : user-dongjin-eks
레포지터리   : 422489764856.dkr.ecr.ca-central-1.amazonaws.com
접속 URL     : https://meuron-sk.signin.aws.amazon.com/console
파일 시스템  : fs-dc545c31
AWS_ACCOUNT_ID : 422489764856
KUBE_URL : https://E1B761DB2E500713EA1BE5895042085D.gr7.ca-central-1.eks.amazonaws.com    (EKS -> user-dongjin-eks -> 구성 탭 -> 세부정보 -> API 서버 엔트포인트 복사)
KUBE_TOKEN :

◆ IAM 보안 자격증명 설정 (한번 설정한 경우 다시 설정필요 없음) (*Container-Orchestration(AWS)_2021.pdf – P59 ~P61 참조)
> aws configure
AWS Access Key ID [None]: 
AWS Secret Access Key [None]: 
Default region name [None]: ca-central-1
Default output format [None]: json

◆ AWS 클러스터 생성(EKS)  (한번 생성한 경우 다시 생성 필요 없음) (생성에 시간 오래 걸림 10분)
> eksctl create cluster --name user-dongjin-eks --version 1.19 --nodegroup-name standard-workers --node-type t3.medium --nodes 4 --nodes-min 1 --nodes-max 4
클러스터 삭제시 
> eksctl delete cluster --region=ca-central-1 --name=user-dongjin-eks

◆ AWS 클러스터 토큰 가져오기
> aws eks --region ca-central-1 update-kubeconfig --name user-dongjin-eks
> kubectl get all
> kubectl config current-context

◆ AWS 컨테이너 레지스트리(ECR) 로그인
> docker login --username AWS -p $(aws ecr get-login-password --region ca-central-1) 422489764856.dkr.ecr.ca-central-1.amazonaws.com/

◆ Metric-Server 설치  (이미 설치한 경우에는 추가 설치 필요 없음)
> kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/download/v0.5.0/components.yaml
> kubectl top node  (** 시간이 조금 걸림)


	마이크로서비스 배포 (CodeBuild)
◆ ECR(Elastic Container Repositoy) 생성  (주의 ECR의 레파지토리 명에 "_", 대문자가 들어가면  Repository 생성시  Error가 발생 함.)
	gateway 서비스
> aws ecr create-repository --repository-name user-dongjin-gateway --region ca-central-1
	Reservation 서비스
> aws ecr create-repository --repository-name user-dongjin-reservation --region ca-central-1
	Pay 서비스
> aws ecr create-repository --repository-name user-dongjin-pay --region ca-central-1
	Store 서비스
> aws ecr create-repository --repository-name user-dongjin-store --region ca-central-1
	Supplier 서비스
> aws ecr create-repository --repository-name user-dongjin-supplier --region ca-central-1
	View 서비스
> aws ecr create-repository --repository-name user-dongjin-view --region ca-central-1

◆ CodeBuild 설정 (AWS-CICD-Pipeline_2021.pdf, P36 ~ P53 참고)
	CodeBuild에 사용될 환경변수
AWS_ACCOUNT_ID
KUBE_URL
KUBE_TOKEN
	CodeBuild와 ECR 연결정책 JSON ( 정책명 ex) user-dongjin-reservation-codebuild-policy)
{
      "Action": [
        "ecr:BatchCheckLayerAvailability",
        "ecr:CompleteLayerUpload",
        "ecr:GetAuthorizationToken",
        "ecr:InitiateLayerUpload",
        "ecr:PutImage",
        "ecr:UploadLayerPart"
      ],
      "Resource": "*",
      "Effect": "Allow"
 }
◆ CodeBuild 에서 EKS 연결 
  쿠버네티스에 접속하기 위해서는 쿠버네티스API주소 와 클러스터 어드민 권한이 있는 토큰이 있으면 접속 가능.
( 실제로 kubectl 명령어가 두개의 조합으로 이루어 져 있음 )
	Kubernates API 주소 위치 
 




	Service Account 생성
> cat <<EOF | kubectl apply -f -
apiVersion: v1
kind: ServiceAccount
metadata:
  name: eks-admin
  namespace: kube-system
EOF

	ClusterRoleBinding 생성
> cat <<EOF | kubectl apply -f -
apiVersion: rbac.authorization.k8s.io/v1beta1
kind: ClusterRoleBinding
metadata:
  name: eks-admin
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
- kind: ServiceAccount
  name: eks-admin
  namespace: kube-system
EOF

	SA로 EKS 접속 토큰 가져오기
> kubectl -n kube-system describe secret eks-admin
# token 결과값만 공백없이 복사

◆ buildspec-kubectl.yaml 수정
	각 service의 buildspec-kubectl.yaml 에서 line5.6 값 이미지 Name에 맞게 수정. 

◆ 배포 서비스 확인
	배포 Service  확인
> kubectl get all

◆ Kafka 설치 (gatway를 제외하고는 각 서비스가 kafka에 연결하므로 kafka 서비스가 떠 있지 않으면 pod, deployment  올라오지 않음.)
                * helm 설치 필요.  (http://34.117.35.195/operation/checkpoint/check-point-two/ 참고)
> kubectl --namespace kube-system create sa tiller 
> kubectl create clusterrolebinding tiller --clusterrole cluster-admin --serviceaccount=kube-system:tiller

> helm repo add incubator https://charts.helm.sh/incubator
> helm repo update
> kubectl create ns kafka
> helm install my-kafka --namespace kafka incubator/kafka --debug

> kubectl get svc my-kafka -n kafka
> kubectl -n
