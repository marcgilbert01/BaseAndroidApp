package com.example.domain.parisEvent.usecase

import com.example.domain.parisEvent.entity.ParisEvent
import com.example.domain.parisEvent.repository.ParisEventRepo

class GetParisEventUseCaseImplCo(
    private val parisEventRepo: ParisEventRepo
) : GetParisEventListUseCaseCo {

    override suspend fun exeUseCase(): List<ParisEvent> {
        return parisEventRepo.getParisEventList()
    }
}