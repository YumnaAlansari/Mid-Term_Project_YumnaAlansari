package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    Optional<Cinema> findById(Long id); // This id

}
