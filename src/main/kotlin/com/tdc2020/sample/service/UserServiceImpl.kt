package com.tdc2020.sample.service

// import com.fasterxml.jackson.databind.ObjectMapper
// import com.tdc2020.sample.message.KafkaProducer
import com.tdc2020.sample.entity.User
import com.tdc2020.sample.repository.elastic.UserElasticRepository
import com.tdc2020.sample.repository.mongo.UserMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userMongoRepository: UserMongoRepository

    @Autowired
    lateinit var userElasticRepository: UserElasticRepository

    // @Autowired
    // lateinit var kafkaProducer: KafkaProducer

    // @Autowired
    // lateinit var mailService: JavaMailSenderService

    override fun findByFirstNameAndLastNameAndProfile(firstName: String, lastName: String, profile: String): List<User> {
        return userElasticRepository.findByFirstNameContainingOrLastNameContainingOrProfileContaining(firstName, lastName, profile)
    }

    override fun findSimilar(firstName: String, lastName: String, profile: String): List<User> {
        val userToSearch = User()
        userToSearch.id = ""
        userToSearch.firstName = firstName
        userToSearch.lastName = lastName
        userToSearch.profile = profile
        return userElasticRepository.searchSimilar(userToSearch, arrayOf("id", "firstName", "lastName", "profile"), PageRequest.of(1, 20)).toList()
    }

    override fun save(user: User): User {

        if(user.id.equals("") ){
            val uuid = UUID.randomUUID()
            val randomUUIDString = uuid.toString()
            user.id = randomUUIDString
        }

        val savedUser = userMongoRepository.save(user)
        userElasticRepository.save(savedUser)

        // val objectMapper = ObjectMapper()
        // kafkaProducer.sendMessageWithDefaultTopic(objectMapper.writeValueAsString(savedUser))

        return savedUser
    }

    override fun deleteById(userId: String) {
        userMongoRepository.deleteById(userId)
        userElasticRepository.deleteById(userId)
    }
}