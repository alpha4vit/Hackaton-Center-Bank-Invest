package com.bank.dto;

import com.bank.models.Landmark;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewLandmarkDTO {
    private Long id;
    private String title;
    private String message;
    private Long landmark_id;
    private int stars;
    private int likes;
}
