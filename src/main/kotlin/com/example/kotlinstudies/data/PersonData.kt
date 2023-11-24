package com.example.kotlinstudies.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "person")
data class PersonData (
        @field:NotEmpty @Size(min = 3, max = 80) val name: String,
        @field:NotEmpty @Size(max = 12) val surname: String,
        @field:NotNull val age: Int
) {
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE) val id: Int = 0 //is this the best way?
}