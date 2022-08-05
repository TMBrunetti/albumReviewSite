package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.model.Album;
import org.wcci.apimastery.model.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.SongRepository;

@RestController
public class SongController {
    private SongRepository songRepo;
    private AlbumRepository albumRepo;

    public SongController(SongRepository songRepo, AlbumRepository albumRepo) {
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
    }

    @GetMapping("/api/songs")
    public Iterable<Song> retrieveAllSongs() { return songRepo.findAll(); }

    @GetMapping("/api/songs/{id}")
    public Song retrieveSongById(@PathVariable Long id) { return songRepo.findById(id).get(); }

//    @PostMapping("/api/albums")
//    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd){
//        albumRepo.save(albumToAdd);
//        return albumRepo.findAll();
//    }


}
