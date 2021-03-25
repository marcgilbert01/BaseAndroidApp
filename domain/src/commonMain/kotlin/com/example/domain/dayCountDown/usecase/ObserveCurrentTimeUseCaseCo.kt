package com.example.domain.dayCountDown.usecase

import com.example.domain.common.UseCaseVoidCo
import kotlinx.coroutines.flow.Flow

interface ObserveCurrentTimeUseCaseCo : UseCaseVoidCo<Flow<Long>> {

    override suspend fun exeUseCase(): Flow<Long>
}