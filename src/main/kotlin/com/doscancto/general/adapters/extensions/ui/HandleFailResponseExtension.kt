package com.doscancto.general.adapters.extensions.ui

import com.doscancto.general.domain.exceptions.ValidationFailException
import jakarta.ws.rs.core.Response

fun Throwable?.formatResponse(): Response {

    if(this is ValidationFailException)
    {
        return Response.status(400).entity(this.toFormatedFail()).build()
    }

    return Response.status(500).entity(object  { val msg = "Something went wrong" }).build()
}


fun <T> Result<T>.formatFailResponse(): Response = this.exceptionOrNull().formatResponse()