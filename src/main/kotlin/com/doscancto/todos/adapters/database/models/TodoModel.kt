package com.doscancto.todos.adapters.database.models

import com.doscancto.todos.domain.entities.TodoEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.PersistenceContext
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "todo")
data class TodoModel (
    @field:Id
    @field:GeneratedValue
    var id: UUID?,

    var title: String,

    var completed: Boolean,
)
{
    constructor() : this(null, "", false)
    constructor(e: TodoEntity) : this(UUID.fromString(e.id), e.name, e.completed)

    fun toEntity(): TodoEntity {
        return TodoEntity(
            id = this.id.toString(),
            name = this.title,
            completed = this.completed
        )
    }

    companion object {
        @PersistenceContext
        fun fromEntity(e: TodoEntity): TodoModel {
            e.id = UUID.randomUUID().toString()

            val a = TodoModel(e)

            a.id = null;

            return  a
        }
    }
}