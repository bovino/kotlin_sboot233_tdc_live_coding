package com.tdc2020.sample.service

import com.tdc2020.sample.entity.User

interface UserService {
    fun findByFirstNameAndLastNameAndProfile(firstName: String, lastName: String, profile: String): List<User>
    fun findSimilar(firstName: String, lastName: String, profile: String): List<User>
    fun save(user: User): User
    fun deleteById(userId: String)
}