package com.example.biografkinoofficial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;  // Auto-generated ID

  private String title;
  private Date release_date;
  private double rating;
  private double length;
  private String genre;
  private int age_limit;

  public Movie(String title, Date release_date, double rating, double length, String genre, int age_limit) {
    this.title = title;
    this.release_date = release_date;
    this.rating = rating;
    this.length = length;
    this.genre = genre;
    this.age_limit = age_limit;
  }
  public Movie() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getRelease_date() {
    return release_date;
  }

  public void setRelease_date(Date releaseDate) {
    this.release_date = releaseDate;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getAge_limit() {
    return age_limit;
  }

  public void setAge_limit(int ageLimit) {
    this.age_limit = ageLimit;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
