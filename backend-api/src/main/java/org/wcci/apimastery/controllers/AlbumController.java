package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.model.Album;
import org.wcci.apimastery.model.Review;
import org.wcci.apimastery.model.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.ReviewRepository;
import org.wcci.apimastery.repositories.SongRepository;

import java.util.Optional;

@RestController
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private ReviewRepository reviewRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo, ReviewRepository reviewRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums() {
        return albumRepo.findAll();
    }

    @GetMapping("/api/albums/{id}")
    public Album retrieveAlbumById(@PathVariable Long id) {
        return albumRepo.findById(id).get();
    }

    @DeleteMapping("/api/albums/{id}/deleteAlbumById")
    public Iterable<Album> deleteAlbumById(@PathVariable Long id){
        albumRepo.deleteById(id);
        return albumRepo.findAll();
    }

    @PostMapping("/api/addAlbums")
    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd) {
        albumRepo.save(albumToAdd);
        return albumRepo.findAll();
    }

    @PatchMapping("/api/albums/{id}/addSong")
    public Iterable<Song> addSong(@RequestBody Song songtoadd,@PathVariable Long id) {
        Album newAlbum =    albumRepo.findById(id).get();
        Song newSong = new Song(songtoadd.getName(),songtoadd.getArtist(),newAlbum,songtoadd.getDuration());
        songRepo.save(newSong);
        return songRepo.findAll();
    }

    @PatchMapping("/api/albums/{id}/addReview")
    public Iterable<Review> addReview(@RequestBody Review reviewToAdd, @PathVariable Long id) {
        Album newAlbum = albumRepo.findById(id).get();
        Review newReview = new Review(reviewToAdd.getContent(), reviewToAdd.getRating(), newAlbum);
        reviewRepo.save(newReview);
        return reviewRepo.findAll();
    }

}

