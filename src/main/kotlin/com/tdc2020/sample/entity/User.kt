package com.tdc2020.sample.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.io.Serializable

@Document(indexName = "user-store", type = "user", replicas = 0)
data class User (
        @Id
        var id: String,
        var firstName: String,
        var lastName: String,
        var profile: String,
        var email: String
) : Serializable {
    constructor() : this("", "", "", "", "")
}