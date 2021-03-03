package com.example.domain.parisEvent.repository

import com.example.domain.parisEvent.entity.ParisEvent

interface ParisEventRepo {

    suspend fun getParisEventList(): List<ParisEvent>
}