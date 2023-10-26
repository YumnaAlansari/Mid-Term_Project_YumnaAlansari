package SDAIronHack.ArtHouse.Controller.impl;


import SDAIronHack.ArtHouse.Controller.interfaces.ICinemaController;
import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Service.interfaces.ICinemaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CinemaController implements ICinemaController {

    @Autowired
    ICinemaService cinemaService;

    // Get Requests
    @GetMapping("/Cinema")
    @ResponseStatus (HttpStatus.OK)
    public List<Cinema> getAllCinema(){
        return cinemaService.getAllCinema();
    }

    @GetMapping("/Cinema/getById/{id}")
    @ResponseStatus (HttpStatus.OK)
    public Optional<Cinema> getCinemaById(@PathVariable Long id){
        return cinemaService.getCinemaById(id);
    }

    @GetMapping("/Cinema/getByDirector/{director}")
    @ResponseStatus (HttpStatus.OK)
    public List<Cinema> getCinemaByDirector(@PathVariable String director){
        return cinemaService.getCinemaByDirector(director);
    }
    @GetMapping("/Cinema/getByReleaseYear/{releaseYear}")
    @ResponseStatus (HttpStatus.OK)
    public List<Cinema> getCinemaByReleaseYear(@PathVariable int releaseYear){
        return cinemaService.getCinemaByReleaseYear(releaseYear);
    }

    @GetMapping("/Cinema/getByCategory/category")
    @ResponseStatus (HttpStatus.OK)
    public List<Cinema> getCinemaByCategory(@RequestParam String category){
        return cinemaService.getCinemaByCategory(category);
    }

    @PostMapping("/Cinema/addCinema")
    @ResponseStatus (HttpStatus.CREATED)
    public void addCinema(@RequestBody Cinema cinema){
        cinemaService.addCinema(cinema);
    }

    @PutMapping("/Cinema/updateById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCinemaById(@RequestBody @Valid Cinema cinema, @PathVariable Long id) {
        cinemaService.updateMusicById(cinema, id);
    }
    @DeleteMapping("/Cinema/deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCinemaById(@PathVariable Long id) {
       cinemaService.deleteById(id);
    }

}
