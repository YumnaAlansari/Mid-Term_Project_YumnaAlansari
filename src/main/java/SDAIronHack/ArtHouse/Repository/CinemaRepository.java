package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    List<Cinema> findCinemaByDirector(String director);

    List<Cinema> findCinemaByReleaseYear(int releaseYear);

    List<Cinema> findCinemaByCategory(String category);

}
