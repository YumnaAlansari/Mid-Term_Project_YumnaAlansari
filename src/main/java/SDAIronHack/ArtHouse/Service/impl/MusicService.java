package SDAIronHack.ArtHouse.Service.impl;


import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Repository.MusicRepository;
import SDAIronHack.ArtHouse.Service.interfaces.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {

    @Autowired
    MusicRepository musicRepository;

    @Override
    public List<Music> getAllMusic() {
        List<Music> musicList = musicRepository.findAll();
        if (musicList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The music list not found");
        return musicList;
    }

    @Override
    public Optional<Music> getMusicById(Long id) {
        Optional<Music> musicOptional = musicRepository.findById(id);
        if (musicOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + id + " not found");
        return musicOptional;
    }

    @Override
    public List<Music> getMusicByGenre(String genre) {
        List<Music> musicList = musicRepository.findMusicByGenre(genre);
        if (musicList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The genre " + genre + " not found");
        return musicList;
    }

    @Override
    public List<Music> getMusicByArtist(String artist) {
        List<Music> musicList = musicRepository.findMusicByArtist(artist);
        if (musicList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The artist " + artist + " not found");
        return musicList;
    }

    @Override
    public List<Music> getMusicByReleaseYear(int releaseYear) {
        List<Music> musicList = musicRepository.findMusicByReleaseYear(releaseYear);
        if (musicList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The releaseYear " + releaseYear + " not found");
        return musicList;
    }

    @Override
    public void updateMusicById(Music music, Long id) {
            Optional<Music> musicOptional = musicRepository.findById(id);
            if (musicOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + id + " not found");
            music.setId(id);
            musicRepository.save(music);
    }


    // Post (Save) + delete

}
