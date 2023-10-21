package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.ArtHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtHouseRepository extends JpaRepository<ArtHouse,Long> {
}
