package com.audreysperry.moviereview.controllers;

import com.audreysperry.moviereview.models.Movie;
import com.audreysperry.moviereview.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {

    @Autowired
    private MoviesRepository movieRepo;

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
}
