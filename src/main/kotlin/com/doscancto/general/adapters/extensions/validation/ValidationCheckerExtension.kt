package com.doscancto.general.adapters.extensions.validation

import br.com.fluentvalidator.AbstractValidator
import br.com.fluentvalidator.context.ValidationResult
import com.doscancto.general.domain.exceptions.ValidationErr
import com.doscancto.general.domain.exceptions.ValidationFailException

fun <T> AbstractValidator<T>.check(input: T): ValidationFailException?
{
    val res = this.validate(input)

    if(res.isValid)
    {
        return null
    }

    val errors = res.errors.filterNotNull().map { e ->
        ValidationErr(
            field = e.field ?: "",
            error = e.message ?: ""
        )
    };

    return ValidationFailException(
        msg = "Validation fail",
        errors = errors
    )
}

