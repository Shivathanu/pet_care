package pt.uporto.les.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.uporto.les.petcare.model.dto.input.ReviewInputDto;
import pt.uporto.les.petcare.model.review.Review;
import pt.uporto.les.petcare.model.review.ReviewHistory;
import pt.uporto.les.petcare.service.ReviewService;

import java.util.List;

@RestController
public class ReviewController {


    @Autowired
    private ReviewService service;

    @CrossOrigin
    @GetMapping(value = "/api/review", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Review> list() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/api/review/{rId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Review find(@PathVariable("rId") Long petId) {
        return service.findById(petId).orElseThrow(() -> new RuntimeException("Review id not found: " + petId));
    }

    @CrossOrigin
    @PostMapping(value = "/api/review", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody ReviewHistory rInputDto) {
        Review savedR = this.service.save(rInputDto);

        return ResponseEntity.ok(savedR);
    }

}
