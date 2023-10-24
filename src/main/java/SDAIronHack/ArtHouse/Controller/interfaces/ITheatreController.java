package SDAIronHack.ArtHouse.Controller.interfaces;

import SDAIronHack.ArtHouse.Controller.dto.TheatreCategoryDTO;
import SDAIronHack.ArtHouse.Model.Theatre;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ITheatreController {


    public List<Theatre> getAllTheatre();
    public Optional<Theatre> getTheatreById(Long id);
    public List<Theatre> getTheatreByPlayWright(String playWright);
    public List<Theatre> getTheatreByNumberOfActors(int numberOfActors);
    public List<Theatre> getTheatreByCategory(String category);
    public void addTheatre(Theatre theatre);
    public void changeTheatreCategory(TheatreCategoryDTO theatreCategoryDTO, Long id);
    public void deleteTheatreById(Long id);

}
