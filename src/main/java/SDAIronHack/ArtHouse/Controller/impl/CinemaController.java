package SDAIronHack.ArtHouse.Controller.impl;


import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Repository.CinemaRepository;
import SDAIronHack.ArtHouse.Service.interfaces.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CinemaController {

    @Autowired
    ICinemaService cinemaService;
    @Autowired
    CinemaRepository cinemaRepository;

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

    // Post Request
    @PostMapping("/Cinema/addCinema")
    @ResponseStatus (HttpStatus.CREATED)
    public Cinema addCinema(@RequestBody Cinema cinema){
        return cinemaRepository.save(cinema);
    }


    // Delete Request
    @DeleteMapping("/Cinema/deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCinemaById(@PathVariable Long id) {
       cinemaRepository.deleteById(id);
    }

}
