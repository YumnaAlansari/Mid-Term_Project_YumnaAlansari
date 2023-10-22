package SDAIronHack.ArtHouse.Service.impl;

import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Repository.CinemaRepository;
import SDAIronHack.ArtHouse.Service.interfaces.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CinemaService implements ICinemaService {

    @Autowired
    CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema(){
        return cinemaRepository.findAll();
    }
    public Optional<Cinema> getCinemaById(Long id){
        return cinemaRepository.findById(id);
    }
    @Override
    public List<Cinema> getCinemaByDirector(String director) {
        return cinemaRepository.findByDirector(director);
    }

    @Override
    public List<Cinema> getCinemaByReleaseYear(int releaseYear) {
        return cinemaRepository.findByReleaseYear(releaseYear);
    }

    @Override
    public List<Cinema> getCinemaByCategory(String category) {
        return cinemaRepository.findByCategory(category);
    }
}
