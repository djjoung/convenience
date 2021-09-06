package convenience.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="storeReservations", path="storeReservations")
public interface StoreReservationRepository extends JpaRepository<StoreReservation, Long>{


}
