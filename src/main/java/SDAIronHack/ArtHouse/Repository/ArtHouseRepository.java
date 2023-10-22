package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.ArtHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtHouseRepository extends JpaRepository<ArtHouse,Long> {

    Optional<ArtHouse> findById(Long id);
}
