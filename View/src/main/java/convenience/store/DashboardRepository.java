package convenience.store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

    Dashboard findByReserveId(Long reserveId);

}