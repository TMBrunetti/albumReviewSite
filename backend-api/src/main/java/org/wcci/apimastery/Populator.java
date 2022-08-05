package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.model.Album;
import org.wcci.apimastery.model.Review;
import org.wcci.apimastery.model.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.ReviewRepository;
import org.wcci.apimastery.repositories.SongRepository;

@Component
public class Populator implements CommandLineRunner {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private ReviewRepository reviewRepo;

    public Populator(AlbumRepository albumRepo, SongRepository songRepo, ReviewRepository reviewRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Album album1 = new Album("Absolution","Muse",
                "Muse, Wow! It's a band! They play rock! They rock!!!",
                "https://static.gigwise.com/artists/AbsolutionMuse.jpg","Not Roc-a-fela");
        Album album2 = new Album("Boston","Boston","Not just a city, but also something the elderly folks snap fingers to",
                "https://cdn.musebycl.io/2020-10/boston.jpg","Not Roc-a-fela");
        Album album3 = new Album("Blue Print","Jay-Z","Dropped on Sept 11,2001... never forget Jay-Z",
                "https://i1.sndcdn.com/artworks-tdUyQqOPVgwIGDV1-GpUkqA-t500x500.jpg","Roc-a-fela");
        Album album4 = new Album("Album of Disappointing Greatness","Donk-EEE"," Meatball turkey beef venison jowl shank flank bacon fatback chicken ham strip steak picanha short loin salami.",
                "https://i.pinimg.com/736x/f0/08/2c/f0082cef73aaa7b45c0b5eed57aa8d9a--mule-basset-hound.jpg","Self Produced Deuce");

        albumRepo.save(album1);
        albumRepo.save(album2);
        albumRepo.save(album3);
        albumRepo.save(album4);

        Song song1 = new Song("Uprising","Muse", album1,"4:20");
        Song song2 = new Song("More Than A Feeling","Boston", album2,"4:20");
        Song song3 = new Song("99 Problems","Jay-Z", album3,"4:20");
        Song song4 = new Song("Hee Haw at the Hoe Down","Donk-EEE", album4,"4:20");
        Song song5 = new Song("Resistance","Muse", album1,"4:20");
        Song song6 = new Song("Super Massive Black-Hole","Muse", album1,"4:20");
        Song song7 = new Song("Psycho","Muse", album1,"4:20");

        songRepo.save(song1);
        songRepo.save(song2);
        songRepo.save(song3);
        songRepo.save(song4);
        songRepo.save(song5);
        songRepo.save(song6);
        songRepo.save(song7);

        Review review1 = new Review("Masterpiericing my soul", 10, album1);
        Review review2 = new Review("Boring", 5, album1);
        Review review3 = new Review("Loved it", 2, album1);

        reviewRepo.save(review1);
        reviewRepo.save(review2);
        reviewRepo.save(review3);

    }
}
