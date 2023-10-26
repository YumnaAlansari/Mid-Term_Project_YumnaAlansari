package SDAIronHack.ArtHouse.Controller.interfaces;

import SDAIronHack.ArtHouse.Model.Cinema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ICinemaController {

    public List<Cinema> getAllCinema();
    public Optional<Cinema> getCinemaById(Long id);
    public List<Cinema> getCinemaByDirector(String director);
    public List<Cinema> getCinemaByReleaseYear( int releaseYear);
    public List<Cinema> getCinemaByCategory(String category);
    public void addCinema( Cinema cinema);
    public void updateCinemaById( Cinema cinema, Long id);
    public void deleteCinemaById(Long id);


}
