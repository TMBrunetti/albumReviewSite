package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.model.Review;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository <Review,Long>{
//    Optional<Review> findByNameIgnoreCase(String input);
}
