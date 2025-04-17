package com.shuwaiee.classroomb

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Int> {
    fun deleteAllByResturantName(resturantName: String)
}

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(name = "name")
    var fullName: String,
    var age: Int?,
//    @OneToMany
//    var orders: List<OrderEntity>,
) {
    constructor() : this(0, "", null)
}

@Repository
interface OrderRepository : JpaRepository<OrderEntity, Int> {
    // Derived Query JPA
    fun searchByResturantName(resturantName: String): List<OrderEntity>
}

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    //@Column(name = "full_name")
    var userId: Int,
    var resturantName:String?,
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    var user: UserEntity?,
) {
    constructor() : this(0,0,null)
}