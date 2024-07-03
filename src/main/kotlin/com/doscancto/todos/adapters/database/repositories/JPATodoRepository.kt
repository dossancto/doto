package com.doscancto.todos.adapters.database.repositories

import com.doscancto.todos.adapters.database.models.TodoModel
import com.doscancto.todos.domain.entities.TodoEntity
import com.doscancto.todos.domain.ports.TodoRepository
import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import java.util.*
import kotlin.jvm.optionals.getOrNull

@ApplicationScoped
class JPATodoRepository : PanacheRepository<TodoModel>, TodoRepository {

  override fun getUserById(id: UUID): TodoEntity? {
    val a = find("id", id).firstResultOptional<TodoModel>()

    return a.getOrNull()?.toEntity()
  }

  @Transactional
  override fun create(entity: TodoEntity): String {
    val model = TodoModel.fromEntity(entity)

    persist(model)

    return model.id.toString()
  }

  override fun selectAll(): List<TodoEntity> {
    return listAll().map { x -> x.toEntity() }
  }

  @Transactional
  override fun delete(id: String) {
    val uuid = UUID.fromString(id)

    val model = find("id", uuid).firstResultOptional<TodoModel>()

    if (!model.isPresent()) {
      return
    }

    delete(model.get())
  }
}

