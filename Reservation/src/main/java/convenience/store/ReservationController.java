package convenience.store;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	//@ApiOperation(value = "예약 상품 리스트 가져오기")
	@GetMapping("/list")
	public ResponseEntity<List<Reservation>> getReservationList() {
		List<Reservation> reservations = reservationRepository.findAll();
		return ResponseEntity.ok(reservations);
	}
	
	//@ApiOperation(value = "예약 상품 가져오기")
	@GetMapping("/get/{id}")
	public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
		Reservation reservation = reservationRepository.findById(id).orElseThrow(null);
		return ResponseEntity.ok(reservation);
	}	
	
	//@ApiOperation(value = "상품 예약하기")	
	@PostMapping("/order")
	public ResponseEntity<Reservation> reserveProduct(@RequestBody Reservation reservation) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(Calendar.getInstance().getTime());
		reservation.setDate(dateStr);
		reservation.setStatus("RESERVE");
		Reservation savedReservation = reservationRepository.save(reservation);
		return ResponseEntity.ok(savedReservation);
	}
	
	//@ApiOperation(value = "예약 취소하기")
	@PatchMapping("/cancel/{id}")
	public ResponseEntity<Reservation> cancelReservation(@PathVariable Long id) {
		Reservation reservation = reservationRepository.findById(id).orElseThrow(null);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(Calendar.getInstance().getTime());
		reservation.setDate(dateStr);
		reservation.setStatus("CANCEL");
		Reservation canceledReservation = reservationRepository.save(reservation);
		return ResponseEntity.ok(canceledReservation);
	}
	
	@PatchMapping("/deleteall")
	public ResponseEntity<String> deleteAll() {
		reservationRepository.deleteAll();
		return ResponseEntity.ok("DELETED");
	}


	// CPU 부하 코드
	@GetMapping("/hpa")
	public String testHPA(){
		double x = 0.0001;
		String hostname = "";
		for (int i = 0; i <= 1000000; i++){
			x += java.lang.Math.sqrt(x);
		}
		try{
			hostname = java.net.InetAddress.getLocalHost().getHostName();
		} catch(java.net.UnknownHostException e){
			e.printStackTrace();
		}

		return "====== HPA Test(" + hostname + ") ====== \n";
	}	
	
}