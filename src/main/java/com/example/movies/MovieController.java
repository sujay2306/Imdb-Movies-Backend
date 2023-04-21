package com.example.movies;

import jakarta.servlet.http.PushBuilder;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }
//    @GetMapping("/{id}")
//    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
//        return new ResponseEntity<>(service.findMovieByImdbId(id), HttpStatus.OK);
//    }


    @GetMapping("/{imdbid}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbid){
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbid), HttpStatus.OK);
    }
}


