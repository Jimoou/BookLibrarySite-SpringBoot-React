package com.reactlibraryproject.springbootlibrary.Entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    @CreationTimestamp
    private Date date;

    private double rating;

    private Long bookId;

    private String reviewDescription;

}
