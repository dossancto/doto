package com.doscancto.todos.adapters.ui

import com.doscancto.general.adapters.extensions.ui.formatFailResponse
import com.doscancto.todos.application.usecases.create.CreateTodoInput
import com.doscancto.todos.application.usecases.create.CreateTodoUseCase
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import java.net.URI

@Path("/todo")
class CreateTodoResource(
    private val createTodo: CreateTodoUseCase
) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create(request: CreateTodoInput): Response? {

        val res = createTodo.execute(request)

        if(res.isFailure)
        {
            return res.formatFailResponse()
        }

        val createdTodo = res.getOrThrow();

        val response = Response
            .created(URI(""))
            .entity(createdTodo)
            .build()

        return response
        ;
    }
}