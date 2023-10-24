package SDAIronHack.ArtHouse.Service.interfaces;

import SDAIronHack.ArtHouse.Model.Theatre;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ITheatreService {

    public List<Theatre> getAllTheatre();
    public Optional<Theatre> getTheatreById(Long id);
    public List<Theatre> getTheatreByPlayWright(String playWright);
    public List<Theatre> getTheatreByNumberOfActors( int numberOfActors);
    public List<Theatre> getTheatreByCategory(String category);
    public void changeTheatreCategory(String category, Long id);
    public void addTheatre(Theatre theatre);
    public void deleteTheatreById(Long id);

}
