package SDAIronHack.ArtHouse.Controller.impl;


import SDAIronHack.ArtHouse.Controller.dto.TheatreCategoryDTO;
import SDAIronHack.ArtHouse.Model.Theatre;
import SDAIronHack.ArtHouse.Repository.TheatreRepository;
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
    @Autowired // For Post Request
    TheatreRepository theatreRepository;


    // Get Requests
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
    public List<Theatre> getTheatreByCategory(@RequestParam String category){
        return theatreService.getTheatreByCategory(category);
    }

    // Post Request
    @PostMapping("/Theatre/addTheatre")
    @ResponseStatus (HttpStatus.CREATED)
    public Theatre addTheatre(@RequestBody Theatre theatre){
        return theatreRepository.save(theatre);
    }


    // Patch Request
    @PatchMapping("/Theatre/changeCategory/category")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void changeTheatreCategory(@RequestBody TheatreCategoryDTO theatreCategoryDTO, @RequestParam String category){
        theatreService.changeTheatreCategory(theatreCategoryDTO.getCategory(),category );
    }

    // Delete Request
    @DeleteMapping("/Theatre/deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTheatreById(@PathVariable Long id) {
       theatreRepository.deleteById(id);
    }
}
