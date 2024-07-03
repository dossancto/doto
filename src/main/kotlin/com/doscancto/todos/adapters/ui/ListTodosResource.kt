package com.doscancto.todos.adapters.ui

import com.doscancto.todos.application.usecases.select.SelectTodosUseCase
import com.doscancto.todos.application.usecases.select.inputs.SelectAllTodosInput
import com.doscancto.todos.domain.entities.TodoEntity
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/todos")
class ListTodosResource(private val selectTodos: SelectTodosUseCase) {
    @GET
    fun getAllTodos(): List<TodoEntity>{
        return selectTodos.execute(SelectAllTodosInput())
    }
}
