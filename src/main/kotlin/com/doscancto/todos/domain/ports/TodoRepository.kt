package com.doscancto.todos.domain.ports

import com.doscancto.todos.domain.entities.TodoEntity
import java.util.*

interface TodoRepository {
  fun getUserById(id: UUID): TodoEntity?

  fun create(entity: TodoEntity): String

  fun selectAll(): List<TodoEntity>

  fun delete(id: String)
}

