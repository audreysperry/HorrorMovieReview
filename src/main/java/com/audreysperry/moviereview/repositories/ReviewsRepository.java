package com.audreysperry.moviereview.repositories;

import com.audreysperry.moviereview.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends CrudRepository<Review, Long> {
}
