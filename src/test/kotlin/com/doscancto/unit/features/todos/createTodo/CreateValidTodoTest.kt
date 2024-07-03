package com.doscancto.unit.features.todos.createTodo

import com.doscancto.todos.application.usecases.create.CreateTodoInput
import com.doscancto.todos.application.usecases.create.CreateTodoUseCase
import com.doscancto.todos.application.usecases.create.CreateTodoValidation
import com.doscancto.todos.domain.ports.TodoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@QuarkusTest
class CreateValidTodoTest {
    @Test
    fun testCreateValidTodo() {
        // arrange
        val validation = CreateTodoValidation();

        val todoRepository = mockk<TodoRepository>()

        every { todoRepository.create(any()) } returns "some-id"

        val createTodoUsecase = CreateTodoUseCase(validation, todoRepository);

        val input = CreateTodoInput(
            title = "A good Unit Test"
        )

        // when
        val res = createTodoUsecase.execute(input)

        assertFalse(res.isFailure);
        assertTrue(res.isSuccess);

        verify(exactly = 1) { todoRepository.create(any()) }
        // assert
    }
}