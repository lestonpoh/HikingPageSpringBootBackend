package com.example.hikes.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    @Id
    private ObjectId id;
    @DocumentReference
    private User userID;
    private String description;
    private LocalDateTime createdAt;
}
