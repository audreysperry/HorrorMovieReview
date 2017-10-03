package com.audreysperry.moviereview.models;


import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int rating;

    private String reviewtyped;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public String getReviewtyped() {
        return reviewtyped;
    }

    public void setReviewtyped(String reviewtyped) {
        this.reviewtyped = reviewtyped;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
