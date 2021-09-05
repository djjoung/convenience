package convenience.store;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="storeReservations", path="storeReservations")
public interface StoreReservationRepository extends PagingAndSortingRepository<StoreReservation, Long>{


}
