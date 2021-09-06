package convenience.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="stocks", path="stocks")
public interface StockRepository extends JpaRepository<Stock, Long>{


}
