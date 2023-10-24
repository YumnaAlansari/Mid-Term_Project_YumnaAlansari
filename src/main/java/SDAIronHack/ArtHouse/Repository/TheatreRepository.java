package SDAIronHack.ArtHouse.Repository;


import SDAIronHack.ArtHouse.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> findTheatreByPlayWright(String playWright);
    List<Theatre> findTheatreByNumberOfActors(int numberOfActors);
    List<Theatre> findTheatreByCategory(String category);


}
