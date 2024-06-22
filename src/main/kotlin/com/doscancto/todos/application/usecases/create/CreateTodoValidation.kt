package com.doscancto.todos.application.usecases.create

import br.com.fluentvalidator.AbstractValidator
import br.com.fluentvalidator.predicate.ComparablePredicate.equalTo
import br.com.fluentvalidator.predicate.StringPredicate.*
import jakarta.enterprise.context.RequestScoped


@RequestScoped
class CreateTodoValidation() : AbstractValidator<CreateTodoInput>() {
    override fun rules() {
        ruleFor(CreateTodoInput::title)
            .must(stringSizeGreaterThanOrEqual(3))
            .withFieldName(CreateTodoInput::title.name)
            .withMessage { e -> "Title must contain at least 3 chars. Typed ${e.title.length}" }

        ruleFor(CreateTodoInput::title)
            .must(stringSizeLessThanOrEqual(20))
            .withFieldName(CreateTodoInput::title.name)
            .withMessage { e -> "Title must be lower than 20 chars. Typed ${e.title.length}" }
    }
}