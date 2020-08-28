package com.tdc2020.sample.controller

import com.tdc2020.sample.entity.User
import com.tdc2020.sample.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users/")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun findByFirstNameAndLastNameAndProfile(@RequestParam firstName: String, @RequestParam lastName: String,@RequestParam profile: String ): List<User> {
        return userService.findByFirstNameAndLastNameAndProfile(firstName, lastName, profile)
    }

    @GetMapping("search-term")
    fun findSimilar(@RequestParam firstName: String, @RequestParam lastName: String,@RequestParam profile: String): List<User> {
        return userService.findSimilar(firstName, lastName,profile)
    }

    @PutMapping
    fun addUser(@RequestBody user: User): User {
        return userService.save(user)
    }

    @DeleteMapping(value = ["{userId}"])
    fun deleteUser(@PathVariable userId: String) {
        userService.deleteById(userId)
    }

}