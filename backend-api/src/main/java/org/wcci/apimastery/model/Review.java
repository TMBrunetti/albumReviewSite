package org.wcci.apimastery.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private int rating;
    @ManyToOne
    @JsonIgnore
    private Album album;
    public Review(String content, int rating, Album album) {
        this.content = content;
        this.rating = rating;
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && rating == review.rating && Objects.equals(content, review.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, rating);
    }

    public Review() {
    }
    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public int getRating() {
        return rating;
    }
    public Album getAlbum() {
        return album;
    }
}
