package com.example.hikes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Document(collection ="hike" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hike {
    @Id
    private ObjectId id;
    @DocumentReference
    private User userID;
    private String name;
    private String description;
    private String location;
    private int elevation;
    private int difficulty;
    private double duration;
    @DocumentReference
    private List<Comment> commentIds;
    private Date createdAt;


}
