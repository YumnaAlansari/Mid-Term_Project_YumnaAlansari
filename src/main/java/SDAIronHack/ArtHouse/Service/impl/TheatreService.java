package SDAIronHack.ArtHouse.Service.impl;

import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Model.Theatre;
import SDAIronHack.ArtHouse.Repository.TheatreRepository;
import SDAIronHack.ArtHouse.Service.interfaces.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService implements ITheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public List<Theatre> getAllTheatre() {
        List<Theatre> theatreList =  theatreRepository.findAll();
        if (theatreList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The theatre list not found");
        return theatreList;
    }

    @Override
    public Optional<Theatre> getTheatreById(Long id) {
        Optional<Theatre> theatreOptional =  theatreRepository.findById(id);
        if (theatreOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "The id " + id + " not found");
        return theatreOptional;
    }

    @Override
    public List<Theatre> getTheatreByPlayWright(String playWright) {
        List<Theatre> theatreList =  theatreRepository.findTheatreByPlayWright(playWright);
        if (theatreList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The play wright " + playWright + " not found");
        return theatreList;
    }

    @Override
    public List<Theatre> getTheatreByNumberOfActors(int numberOfActors) {
        List<Theatre> theatreList =  theatreRepository.findTheatreByNumberOfActors(numberOfActors);
        if (theatreList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The number of actors " + numberOfActors + " not found");
        return theatreList;
    }

    @Override
    public List<Theatre> getTheatreByCategory(String category) {
        List<Theatre> theatreList =  theatreRepository.findTheatreByCategory(category);
        if (theatreList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The category " + category + " not found");
        return theatreList;
    }

    @Override
    public void changeTheatreCategory(String category, Long id) {
       Optional<Theatre> theatreOptional = theatreRepository.findById(id);
       if (theatreOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + id + " not found");
       Theatre theatre = theatreOptional.get();
       theatre.setCategory(category);
       theatreRepository.save(theatre);
    }

    @Override
    public void addTheatre(Theatre theatre) {
        theatreRepository.save(theatre);
    }

    @Override
    public void deleteTheatreById(Long id) {
        Optional<Theatre> theatreOptional = theatreRepository.findById(id);
        if (theatreOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + id + " not found");
        theatreRepository.deleteById(id);

    }


}
