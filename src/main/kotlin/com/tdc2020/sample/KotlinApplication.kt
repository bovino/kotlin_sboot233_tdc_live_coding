package com.tdc2020.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories("com.tdc2020.sample.repository.mongo")
@EnableElasticsearchRepositories("com.tdc2020.sample.repository.elastic")
@SpringBootApplication
class KotlinApplication

fun main(args: Array<String>) {
	runApplication<KotlinApplication>(*args)
}
