package SDAIronHack.ArtHouse.Service.impl;

import SDAIronHack.ArtHouse.Model.Theatre;
import SDAIronHack.ArtHouse.Repository.TheatreRepository;
import SDAIronHack.ArtHouse.Service.interfaces.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService implements ITheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public List<Theatre> getAllTheatre() {
        return theatreRepository.findAll();
    }

    @Override
    public Optional<Theatre> getTheatreById(Long id) {
        return theatreRepository.findById(id);
    }

    @Override
    public List<Theatre> getTheatreByPlayWright(String playWright) {
        return theatreRepository.getTheatreByPlayWright(playWright);
    }

    @Override
    public List<Theatre> getTheatreByNumberOfActors(int numberOfActors) {
        return theatreRepository.getTheatreByNumberOfActors(numberOfActors);
    }

    @Override
    public List<Theatre> getTheatreByCategory(String category) {
        return theatreRepository.getTheatreByCategory(category);
    }

    @Override
    public void changeTheatreCategory(String category, String category1) {}

}
