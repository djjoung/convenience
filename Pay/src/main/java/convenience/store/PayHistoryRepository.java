package convenience.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="payHistories", path="payHistories")
public interface PayHistoryRepository extends JpaRepository<PayHistory, Long>{
	PayHistory findByReserveId(Long reserveId);
}
