package com.doscancto.todos.domain.entities

data class TodoEntity(
    val id: String,
    var name: String,
    val completed: Boolean,
) {
    constructor() : this("", "default", false)
}
