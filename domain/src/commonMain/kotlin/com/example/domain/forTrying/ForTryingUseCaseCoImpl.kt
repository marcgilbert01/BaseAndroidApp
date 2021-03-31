package com.example.domain.forTrying

import com.example.domain.common.UseCase

class ForTryingUseCaseCoImpl : UseCase<String, ForTryingUseCaseCoImpl.Params> {

    override fun exeUseCase(params: Params): String {
        println("marc param1=${params.param1}")
        return params.param1
    }

    data class Params(val param1: String)
}