package com.tdc2020.sample.repository.mongo

import com.tdc2020.sample.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserMongoRepository : MongoRepository<User, String>