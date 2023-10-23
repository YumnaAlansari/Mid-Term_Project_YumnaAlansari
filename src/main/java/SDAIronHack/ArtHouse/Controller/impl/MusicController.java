package SDAIronHack.ArtHouse.Controller.impl;


import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Model.Theatre;
import SDAIronHack.ArtHouse.Repository.MusicRepository;
import SDAIronHack.ArtHouse.Service.impl.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MusicController {

    @Autowired
    MusicService musicService;
    @Autowired
    MusicRepository musicRepository;

    // Get Requests
    @GetMapping("/Music")
    @ResponseStatus(HttpStatus.OK)
    public List<Music> getAllMusic(){
        return musicService.getAllMusic();
    }

    @GetMapping("/Music/getById/{id}")
    @ResponseStatus (HttpStatus.OK)
    public Optional<Music> getMusicById(@PathVariable Long id){
        return musicService.getMusicById(id);
    }

    @GetMapping("/Music/getByGenre/{genre}")
    @ResponseStatus (HttpStatus.OK)
    public List<Music> getMusicByGenre(@PathVariable String genre){
        return musicService.getMusicByGenre(genre);
    }

    @GetMapping("/Music/getByArtist/artist")
    @ResponseStatus (HttpStatus.OK)
    public List<Music> getMusicByArtist(@RequestParam String artist){
        return musicService.getMusicByArtist(artist);
    }

    @GetMapping("/Music/getByReleaseYear/{releaseYear}")
    @ResponseStatus (HttpStatus.OK)
    public List<Music> getMusicByReleaseYear(@PathVariable int releaseYear){
        return musicService.getMusicByReleaseYear(releaseYear);
    }

    // Post Request
    @PostMapping("/Music/addMusic")
    @ResponseStatus (HttpStatus.CREATED)
    public Music addMusic(@RequestBody Music music){
        return musicRepository.save(music);
    }

    // PUT Requests
    @PutMapping("/Music/updateById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateMusicById(@RequestBody @Valid Music music, @PathVariable Long id) {
        musicService.updateMusicById(music, id);
    }

    // Delete Request
    @DeleteMapping("/Music/deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteMusicById(@PathVariable Long id) {
       musicRepository.deleteById(id);
    }


}
