package com.example.data.parisEvent

import EventListData
import com.example.domain.parisEvent.entity.ParisEvent
import com.example.domain.parisEvent.repository.ParisEventRepo
import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class ParisEventsRepoImpl(
    private val recordsToParisEventConverter: RecordsToParisEventConverter
) : ParisEventRepo {

    override suspend fun getParisEventList(): List<ParisEvent> {
        val httpClient = HttpClient() {
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }
        httpClient.get<EventListData>("https://opendata.paris.fr/api/records/1.0/search/?dataset=que-faire-a-paris-")?.let { eventListData ->
            return recordsToParisEventConverter.mapToDomain(eventListData.records)
        }
    }
}