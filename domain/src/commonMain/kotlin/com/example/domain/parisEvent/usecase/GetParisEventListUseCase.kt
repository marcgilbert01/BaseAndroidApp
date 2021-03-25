package com.example.domain.parisEvent.usecase

import com.example.domain.parisEvent.entity.ParisEvent
import com.example.domain.common.UseCaseVoid

interface GetParisEventListUseCase : UseCaseVoid<List<ParisEvent>> {

    override suspend fun exeUseCase(): List<ParisEvent>
}