package com.example.hikes.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    @DocumentReference
    private User userID;
    private String description;
    @DocumentReference
    private List<Reply> replyIds;
    private LocalDateTime createdAt;
}
