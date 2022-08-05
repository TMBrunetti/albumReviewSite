package org.wcci.apimastery.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.model.Review;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.ReviewRepository;

@RestController
//@RequestMapping("/reviews")
public class ReviewController {
    private ReviewRepository reviewRepo;
    private AlbumRepository albumRepo;

    public ReviewController(ReviewRepository reviewRepo, AlbumRepository albumRepo) {
        this.reviewRepo = reviewRepo;
        this.albumRepo = albumRepo;
    }

    @GetMapping("/api/reviews")
    public Iterable<Review> retrieveAllReviews() {return reviewRepo.findAll(); }
//    public String showAllReviews(Model model) {
//        model.addAttribute("reviews", reviewRepo.findAll());
//        return "allReviews";
//    }


}
