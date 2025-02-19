package com.example.hikes.repository;

import com.example.hikes.model.Reply;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends MongoRepository<Reply, ObjectId> {
}
