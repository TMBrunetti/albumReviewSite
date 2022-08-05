package org.wcci.apimastery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String artist;
    private String imgUrl;
    private String label;
    @OneToMany(mappedBy = "albums", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Song> songs;
    @OneToMany (mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Review> reviews;

    public Album(String name, String artist, String description, String imgUrl, String label) {
        this.name = name;
        this.description = description;
        this.artist = artist;
        this.label = label;
        this.imgUrl = imgUrl;
//        this.reviews = new ArrayList<Review>();
    }
    public Album() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) && Objects.equals(name, album.name) && Objects.equals(description, album.description) && Objects.equals(artist, album.artist) && Objects.equals(imgUrl, album.imgUrl) && Objects.equals(label, album.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, artist, imgUrl, label);
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getArtist() {
        return artist;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public String getLabel() {
        return label;
    }
    public Collection<Song> getSongs() {
        return songs;
    }
    public Collection<Review> getReviews() { return reviews;}
    public void addReview(Review review) {reviews.add(review);}
}
