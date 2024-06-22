package com.doscancto.todos.adapters.database.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "todo")
class TodoModel (
    @field:Id
    @field:GeneratedValue
    val id: UUID,

    val title: String,

    val completed: Boolean,
)
{
    constructor() : this(UUID.randomUUID(), "default", false)

}