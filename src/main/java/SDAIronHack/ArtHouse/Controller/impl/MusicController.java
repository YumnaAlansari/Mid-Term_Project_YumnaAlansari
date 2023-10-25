package SDAIronHack.ArtHouse.Controller.impl;


import SDAIronHack.ArtHouse.Controller.interfaces.IMusicController;
import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Service.impl.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MusicController implements IMusicController {

    @Autowired
    MusicService musicService;

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

    @PostMapping("/Music/addMusic")
    @ResponseStatus (HttpStatus.CREATED)
    public void addMusic(@RequestBody Music music){
        musicService.save(music);
    }

    @PutMapping("/Music/updateById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateMusicById(@RequestBody @Valid Music music, @PathVariable Long id) {
        musicService.updateMusicById(music, id);
    }

    @DeleteMapping("/Music/deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteMusicById(@PathVariable Long id) {
        musicService.deleteById(id);
    }



}
