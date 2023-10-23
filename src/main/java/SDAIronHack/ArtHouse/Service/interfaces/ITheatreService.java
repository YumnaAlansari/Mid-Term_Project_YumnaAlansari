package SDAIronHack.ArtHouse.Service.interfaces;

import SDAIronHack.ArtHouse.Model.Theatre;
import java.util.List;
import java.util.Optional;

public interface ITheatreService {

    public List<Theatre> getAllTheatre();
    public Optional<Theatre> getTheatreById(Long id);
    public List<Theatre> getTheatreByPlayWright(String playWright);
    public List<Theatre> getTheatreByNumberOfActors( int numberOfActors);
    public List<Theatre> getTheatreByCategory(String category);
    public void changeTheatreCategory(String category, String category1);

}
