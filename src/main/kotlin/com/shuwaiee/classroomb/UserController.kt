package com.shuwaiee.classroomb

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userRepository: UserRepository,
    val orderRepository: OrderRepository) {
    @GetMapping("/users")
    fun getAll(): List<UserEntity> {
        var usersIDb = userRepository.delete(1) ?: UserEntity()
        usersIDb.name = "Majed"
        userRepository.save(usersIDb)
        return usersIDb
    }

    @GetMapping("/orders")
    fun getOrder(): List<OrderEntity> {
        return orderRepository.searchByResturantName("Pick")
    }

    @PostMapping("/orders")
    fun saveOrder(@RequestBody order: OrderEntity)
    {
        orderRepository.save(order)
    }

}