package com.example.domain.common

interface UseCaseCo<out Type, in Params> where Type : Any {
    suspend fun exeUseCase(params: Params): Type
}