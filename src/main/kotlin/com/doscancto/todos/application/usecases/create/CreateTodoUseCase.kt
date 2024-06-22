package com.doscancto.todos.application.usecases.create

import com.doscancto.general.adapters.extensions.validation.check
import com.doscancto.general.domain.exceptions.ValidationFailException
import com.doscancto.todos.domain.entities.TodoEntity
import jakarta.enterprise.context.RequestScoped

@RequestScoped
class CreateTodoUseCase(
    private val validation: CreateTodoValidation
) {
    fun execute(input: CreateTodoInput): Result<TodoEntity> {
        val validationFail = validation.check(input)

        if(validationFail != null)
        {
            return Result.failure(validationFail)
        }

        val entity = input.toEntity()

        return Result.success(entity)
    }
}