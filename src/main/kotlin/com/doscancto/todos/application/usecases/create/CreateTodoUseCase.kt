package com.doscancto.todos.application.usecases.create

import com.doscancto.general.adapters.extensions.validation.check
import com.doscancto.general.domain.exceptions.ValidationFailException
import com.doscancto.todos.domain.entities.TodoEntity
import com.doscancto.todos.domain.ports.TodoRepository
import jakarta.enterprise.context.RequestScoped

@RequestScoped
class CreateTodoUseCase(
    private val validation: CreateTodoValidation,
    private val todoRepository: TodoRepository
) {
    fun execute(input: CreateTodoInput): Result<TodoEntity> {
        val validationFail = validation.check(input)

        if(validationFail != null)
        {
            return Result.failure(validationFail)
        }

        val entity = input.toEntity()

        val id = todoRepository.create(entity)

        entity.id = id

        return Result.success(entity)
    }
}