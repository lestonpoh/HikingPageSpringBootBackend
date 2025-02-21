package com.example.hikes.repository;

import com.example.hikes.model.Hike;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HikeRepository extends MongoRepository<Hike, ObjectId> {
    @Query(value = "{}",fields="{name:1,location:1,elevation:1,difficulty:1,duration:1}")
    List<Hike> findAllHikes();

    @Aggregation(pipeline = {
            "{ $addFields: { transformedName: { $toLower: \"$name\" } } }", // Convert name to lowercase
            "{ $addFields: { transformedName: { $replaceAll: { input: \"$transformedName\", find: \" \", replacement: \"-\" } } } }", // Replace spaces with hyphens
            "{ $match: { transformedName: ?0 } }",
            "{ $limit: 1 }"
    })
    Hike findByName(String name);
}
