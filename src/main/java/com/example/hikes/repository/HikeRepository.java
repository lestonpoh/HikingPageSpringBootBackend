package com.example.hikes.repository;

import com.example.hikes.dto.Hike;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HikeRepository extends MongoRepository<Hike, ObjectId> {
    @Query("{'name': ?0}")
    Optional<Hike> findHikeByName(String name);
}
