package com.doscancto.general.domain.exceptions

data class FormatedValidationFail(
    val field: String,
    val errors: List<String>
)

data class ValidationErr(
    val field: String,
    val error: String
)

class ValidationFailException(
    val msg: String,
    val errors: List<ValidationErr>
): Exception(msg) {

    fun toFormatedFail() =
        errors
            .groupBy { x -> x.field }
            .map { e ->
                FormatedValidationFail(
                    field = e.key,
                    errors = e.value.map { y -> y.error }
                )
            }
}