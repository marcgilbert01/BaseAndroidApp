package com.example.domain.parisEvent.entity

data class ParisEvent (
    val eventId: String,
    val title: String? = null,
    val description: String? = null,
    val addressText: String? = null
)