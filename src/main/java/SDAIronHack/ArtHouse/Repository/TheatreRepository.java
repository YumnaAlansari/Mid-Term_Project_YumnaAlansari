package SDAIronHack.ArtHouse.Repository;


import SDAIronHack.ArtHouse.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> getTheatreByPlayWright(String playWright);
    Optional<Theatre> getTheatreByNumberOfActors(int numberOfActors);
    List<Theatre> getTheatreByCategory(String category);
}
