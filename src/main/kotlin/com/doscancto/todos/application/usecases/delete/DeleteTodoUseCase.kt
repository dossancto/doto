package com.doscancto.todos.application.usecases.delete

import com.doscancto.todos.domain.ports.TodoRepository
import jakarta.enterprise.context.RequestScoped

@RequestScoped
class DeleteTodoUseCase(private val todoRepository: TodoRepository) {

  fun execute(input: DeleteTodoInput): Result<Boolean> {

    todoRepository.delete(input.id)

    return Result.success(true)
  }
}
