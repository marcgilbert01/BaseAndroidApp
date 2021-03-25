package com.example.domain.common

interface UseCaseVoidCo<out Type> where Type : Any {
    suspend fun exeUseCase(): Type
}