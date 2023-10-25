package com.bank.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @CollectionTable(name = "posts_images")
    @ElementCollection
    private List<String> images;

    @Column(name = "date_of_publishment")
    private Instant dateOfPublish;

    @Column(name = "date_of_event")
    private Instant dateOfEvent;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "total_stars")
    private Integer totalStars;

    @Column(name = "review_counter")
    private Integer reviewCounter;

    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "event")
    private List<ReviewForEvent> review;
}