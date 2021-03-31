package com.example.domain.common

interface UseCaseVoid<out Type> where Type : Any {
    fun exeUseCase(): Type
}