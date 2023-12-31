package com.example.kotlinstudies.adapter.controller.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class PersonRequestDto (
        @field:NotEmpty @Size(min = 3, max = 80) val name: String,
        @field:NotEmpty @Size(max = 12) val surname: String,
        @field:NotNull val age: Int
) {

}