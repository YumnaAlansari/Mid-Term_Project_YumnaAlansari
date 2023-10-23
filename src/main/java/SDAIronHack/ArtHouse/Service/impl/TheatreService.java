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
        return null;
    }

    @Override
    public Optional<Theatre> getTheatreById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Theatre> getTheatreByPlayWright(String playWright) {
        return null;
    }

    @Override
    public List<Theatre> getTheatreByNumberOfActors(int numberOfActors) {
        return null;
    }

    @Override
    public Optional<Theatre> getTheatreByCategory(String category) {
        return Optional.empty();
    }
}
