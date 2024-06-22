package com.doscancto.todos.domain.ports

import java.util.*

interface TodoRepository {
    fun getUserById(id: UUID);
}