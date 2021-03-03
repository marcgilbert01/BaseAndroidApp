package com.example.domain.parisEvent.usecase

import com.example.domain.parisEvent.entity.ParisEvent
import com.example.domain.parisEvent.repository.ParisEventRepo

class GetParisEventUseCaseImpl(
    private val parisEventRepo: ParisEventRepo
) : GetParisEventListUseCase {

    override suspend fun exeUseCase(): List<ParisEvent> {
        return parisEventRepo.getParisEventList()
    }
}