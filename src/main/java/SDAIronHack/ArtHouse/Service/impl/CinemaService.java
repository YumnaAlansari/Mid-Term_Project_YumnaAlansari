package SDAIronHack.ArtHouse.Service.impl;

import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Repository.CinemaRepository;
import SDAIronHack.ArtHouse.Service.interfaces.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class CinemaService implements ICinemaService {

    @Autowired
    CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema(){
        List<Cinema> cinemaList =  cinemaRepository.findAll();
        if (cinemaList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The cinema list not found");
        return cinemaList;
    }
    public Optional<Cinema> getCinemaById(Long id){
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(id);
        if (cinemaOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + id + " not found");
        return cinemaOptional;
    }
    @Override
    public List<Cinema> getCinemaByDirector(String director) {
        List<Cinema> cinemaList = cinemaRepository.findCinemaByDirector(director);
        if (cinemaList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The director " + director + " not found");
        return cinemaList;
    }
    @Override
    public List<Cinema> getCinemaByReleaseYear(int releaseYear) {
        List<Cinema> cinemaList = cinemaRepository.findCinemaByReleaseYear(releaseYear);
        if (cinemaList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The release year " + releaseYear + " not found");
        return cinemaList;
    }
    @Override
    public List<Cinema> getCinemaByCategory(String category) {
        List<Cinema> cinemaList = cinemaRepository.findCinemaByCategory(category);
        if (cinemaList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The category " + category + " not found");
        return cinemaList;
    }
    @Override
    public void addCinema(Cinema cinema) {
        cinemaRepository.save(cinema);

    }
    @Override
    public void deleteById(Long id) {
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(id);
        if (cinemaOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + id + " not found");
        cinemaRepository.deleteById(id);

    }


}
