package com.audreysperry.moviereview.models;


import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="reviewer_name")
    private String reviewername;
    private int rating;

    @Column(name="reviewer_age")
    private int reviewerAge;

    @Column(name="reviewer_gender")
    private String reviewerGender;

    @Column(name="reviewer_occupation")
    private String reviewerOccupation;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReviewername() {
        return reviewername;
    }

    public void setReviewername(String reviewername) {
        this.reviewername = reviewername;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getReviewerAge() {
        return reviewerAge;
    }

    public void setReviewerAge(int reviewerAge) {
        this.reviewerAge = reviewerAge;
    }

    public String getReviewerGender() {
        return reviewerGender;
    }

    public void setReviewerGender(String reviewerGender) {
        this.reviewerGender = reviewerGender;
    }

    public String getReviewerOccupation() {
        return reviewerOccupation;
    }

    public void setReviewerOccupation(String reviewerOccupation) {
        this.reviewerOccupation = reviewerOccupation;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
