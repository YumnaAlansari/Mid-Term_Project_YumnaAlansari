package SDAIronHack.ArtHouse.Service.interfaces;

import SDAIronHack.ArtHouse.Model.Cinema;

import java.util.List;
import java.util.Optional;

public interface ICinemaService {

    public List<Cinema> getAllCinema();
    public Optional<Cinema> getCinemaById(Long id);
    public List<Cinema> getCinemaByDirector(String director);
    public List<Cinema> getCinemaByReleaseYear( int releaseYear);
    public List<Cinema> getCinemaByCategory(String category);
    public void addCinema(Cinema cinema);
    public void updateMusicById(Cinema cinema, Long id);
    public void deleteById(Long id);

}
