package SDAIronHack.ArtHouse.Controller.impl;


import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Model.Theatre;
import SDAIronHack.ArtHouse.Service.impl.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @GetMapping("/Theatre")
    @ResponseStatus(HttpStatus.OK)
    public List<Theatre> getAllTheatre(){
        return theatreService.getAllTheatre();
    }

    @GetMapping("/Theatre/getById/{id}")
    @ResponseStatus (HttpStatus.OK)
    public Optional<Theatre> getTheatreById(@PathVariable Long id){
        return theatreService.getTheatreById(id);
    }

    @GetMapping("/Theatre/getByPlayWright/playWright")
    @ResponseStatus (HttpStatus.OK)
    public List<Theatre> getTheatreByPlayWright(@RequestParam String playWright){
        return theatreService.getTheatreByPlayWright(playWright);
    }
    @GetMapping("/Theatre/getByNumberOfActors/{numberOfActors}")
    @ResponseStatus (HttpStatus.OK)
    public List<Theatre> getTheatreByNumberOfActors(@PathVariable int numberOfActors){
        return theatreService.getTheatreByNumberOfActors(numberOfActors);
    }
    @GetMapping("/Theatre/getByCategory/category")
    @ResponseStatus (HttpStatus.OK)
    public Optional<Theatre> getTheatreByCategory(String category){
        return theatreService.getTheatreByCategory(category);
    }

}
