package convenience.store;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DashboardRepository extends CrudRepository<Dashboard, Long> {

    List<Dashboard> findByReserveId(Long reserveId);
    //List<Dashboard> findByReserveId(Long reserveId);
    List<Dashboard> findByReserveStatus(String reserveStatus);
    //List<Dashboard> findByReserveStatus(String reserveStatus);

}