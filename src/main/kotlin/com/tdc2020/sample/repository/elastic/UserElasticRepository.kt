package com.tdc2020.sample.repository.elastic

import com.tdc2020.sample.entity.User
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface UserElasticRepository : ElasticsearchRepository<User, String> {
    fun findByFirstNameContainingOrLastNameContainingOrProfileContaining(firstName: String, lastName: String, profile: String): List<User>
}