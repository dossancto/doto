package com.doscancto.todos.application.usecases.select

import com.doscancto.todos.application.usecases.select.inputs.SelectAllTodosInput
import com.doscancto.todos.domain.entities.TodoEntity
import com.doscancto.todos.domain.ports.TodoRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class SelectTodosUseCase(
    private val todoRepository: TodoRepository
) {

    fun execute(input: SelectAllTodosInput): List<TodoEntity> {
        return todoRepository.selectAll()
    }
}