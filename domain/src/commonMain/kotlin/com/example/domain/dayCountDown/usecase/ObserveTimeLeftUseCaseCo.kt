package com.example.domain.dayCountDown.usecase

import com.example.domain.dayCountDown.entity.TimeLeft
import com.example.domain.common.UseCaseCo
import kotlinx.coroutines.flow.Flow

interface ObserveTimeLeftUseCaseCo : UseCaseCo<Flow<TimeLeft>, ObserveTimeLeftUseCaseCo.Params> {

    override suspend fun exeUseCase(params: Params): Flow<TimeLeft>

    data class Params(val dueDateInMillis: Long)
}