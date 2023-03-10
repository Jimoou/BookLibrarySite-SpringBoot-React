package com.reactlibraryproject.springbootlibrary.Controller;

import com.reactlibraryproject.springbootlibrary.RequestModels.ReviewRequest;
import com.reactlibraryproject.springbootlibrary.Service.ReviewService;
import com.reactlibraryproject.springbootlibrary.Utils.ExtractJWT;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value="Authorization") String token,
                                    @RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");

        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return reviewService.userReviewListed(userEmail, bookId);

    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value="Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }
}
