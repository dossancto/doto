package com.doscancto.todos.adapters.ui.DeleteTodo

import com.doscancto.todos.application.usecases.delete.DeleteTodoInput
import com.doscancto.todos.application.usecases.delete.DeleteTodoUseCase
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.Path

@Path("/todos")
class DeleteTodoResource(val deleteUsecase: DeleteTodoUseCase) {

  @DELETE
  @Path("/delete/{id}")
  fun deleteTodo(id: String): String {
    val input = DeleteTodoInput(id)

    val output = deleteUsecase.execute(input)

    return output.getOrNull().toString()
  }
}
