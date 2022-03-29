package DreamDress.DreamDress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DreamDress.DreamDress.model.LocationTraditionnel;
@Repository
public interface LocationTraditionnelRepository  extends JpaRepository<LocationTraditionnel, Long>{

}
