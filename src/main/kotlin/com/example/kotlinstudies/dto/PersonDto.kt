package com.example.kotlinstudies.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class PersonDto (
        @NotEmpty @Size(min = 3, max = 80) val name: String,
        @NotEmpty @Size(max = 12) val surname: String,
        @NotNull val age: Int
) {

}