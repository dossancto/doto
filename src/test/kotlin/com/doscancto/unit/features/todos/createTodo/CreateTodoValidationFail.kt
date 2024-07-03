package com.doscancto.unit.features.todos.createTodo

import com.doscancto.general.domain.exceptions.ValidationFailException
import com.doscancto.todos.application.usecases.create.CreateTodoInput
import com.doscancto.todos.application.usecases.create.CreateTodoUseCase
import com.doscancto.todos.application.usecases.create.CreateTodoValidation
import com.doscancto.todos.domain.ports.TodoRepository
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusTest
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@QuarkusTest

class CreateTodoValidationFail {
    @Test
    fun testCreateInvalidTodo() {
        // arrange
        val validation = CreateTodoValidation();

        val todoRepository = mockk<TodoRepository>()

        every { todoRepository.create(any()) } returns "some-id"

        val createTodoUsecase = CreateTodoUseCase(validation, todoRepository);

        val input = CreateTodoInput(
            title = "pi"
        )

        // when
        val res = createTodoUsecase.execute(input)

        assertTrue(res.isFailure);

        val err = res.exceptionOrNull() as ValidationFailException

        assertEquals(1, err.errors.size)

        assertEquals("title", err.errors[0].field)

        verify(exactly = 0) { todoRepository.create(any()) }
        // assert

    }
}