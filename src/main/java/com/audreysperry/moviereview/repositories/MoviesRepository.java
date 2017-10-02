package com.audreysperry.moviereview.repositories;

import com.audreysperry.moviereview.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {

}
