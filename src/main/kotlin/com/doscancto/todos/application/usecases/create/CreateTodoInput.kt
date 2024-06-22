package com.doscancto.todos.application.usecases.create

import com.doscancto.todos.domain.entities.TodoEntity

data class CreateTodoInput(
    val title: String
)
{
    constructor(): this("")
}


fun CreateTodoInput.toEntity() = TodoEntity(
    id = "",
    name = this.title,
    completed = false
);