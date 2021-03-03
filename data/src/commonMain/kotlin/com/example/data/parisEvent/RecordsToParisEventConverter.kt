package com.example.data.parisEvent

import Records
import com.example.domain.parisEvent.entity.ParisEvent
import com.nowtv.domain.common.BaseMapperToDomain

class RecordsToParisEventConverter : BaseMapperToDomain<Records, ParisEvent>() {
    override fun mapToDomain(toBeTransformed: Records): ParisEvent {
        return ParisEvent(
            eventId = toBeTransformed.recordid!!,
            title = toBeTransformed.fields.title,
            description = toBeTransformed.fields.description,
            addressText = toBeTransformed.fields.address_street + toBeTransformed.fields.address_city,
        )
    }
}