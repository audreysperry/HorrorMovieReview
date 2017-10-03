package com.audreysperry.moviereview.controllers;

import com.audreysperry.moviereview.models.Movie;
import com.audreysperry.moviereview.models.Review;
import com.audreysperry.moviereview.models.User;
import com.audreysperry.moviereview.repositories.MoviesRepository;
import com.audreysperry.moviereview.repositories.ReviewsRepository;
import com.audreysperry.moviereview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MoviesRepository movieRepo;

    @Autowired
    private ReviewsRepository reviewRepo;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/")
    public String displayMovies(Model model) {
        // model.addAttribute("movie", new Movie());
        model.addAttribute("movies", movieRepo.findAll());
        return "index";
    }

    @RequestMapping("/movie/add")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    @RequestMapping(value = "/movie/add", method = RequestMethod.POST)
    public String addMovie(Model model,
                           @ModelAttribute Movie movie){
        movieRepo.save(movie);
        return "redirect:/";

    }

    @RequestMapping("/movie/{id}")
    public String viewMovieDetails(Model model,
                                   @ModelAttribute ("id") long id) {
        Movie movie = movieRepo.findOne(id);
        model.addAttribute(movie);
        return "movieDetail";

    }

    @RequestMapping("/movie/{id}/edit")
    public String editMovieForm(Model model,
                                @ModelAttribute ("id") long id) {
        Movie editMovie = movieRepo.findOne(id);
        model.addAttribute("movie", editMovie);
        return "editMovie";
    }

    @RequestMapping(value= "/movie/{id}/edit", method= RequestMethod.POST)
    public String editMovie(@ModelAttribute Movie movie,
                            @ModelAttribute ("id") long id) {
        movieRepo.save(movie);
        return "redirect:/";
    }

    @RequestMapping(value="/movie/{movieid}/viewReviews")
    public String viewReviews(@PathVariable ("movieid") Long movieid,
                                Model model) {
        Movie movie = movieRepo.findOne(movieid);
        List reviews = movie.getReviews();
        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);
        return "viewReviews";
    }

    @RequestMapping(value="/movie/{movieid}/review")
    public String writeReview(@PathVariable ("movieid") long movieid,
                              Model model) {
        model.addAttribute(movieRepo.findOne(movieid));
        model.addAttribute("review", new Review());
        return "reviewForm";
    }

    @RequestMapping(value="/movie/{movieid}/review", method = RequestMethod.POST)
    public String submitReview(@PathVariable ("movieid") Long movieid,
                               Model model,
                               @ModelAttribute Review review,
                               Principal principal) {
        Movie movie = movieRepo.findOne(movieid);
        User user = userRepo.findByUsername(principal.getName());
        Review newReview = review;
        newReview.setMovie(movie);
        newReview.setUser(user);
        reviewRepo.save(newReview);

        return "redirect:/";
    }
}
