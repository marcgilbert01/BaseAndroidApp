package com.example.factory

import com.example.data.parisEvent.ParisEventsRepoImpl
import com.example.data.parisEvent.RecordsToParisEventConverter
import com.example.domain.dayCountDown.usecase.ObserveCurrentTimeUseCaseImpl
import com.example.domain.dayCountDown.usecase.ObserveTimeLeftUseCaseImpl
import com.example.domain.parisEvent.usecase.GetParisEventUseCaseImpl
import com.example.presenters.dayCountDown.DayCountDownContract
import com.example.presenters.dayCountDown.DayCountDownPresenter

class PresenterFactory {

    fun createDayCountDownPresenter(view: DayCountDownContract.View) : DayCountDownContract.Presenter {
        return DayCountDownPresenter(
            view = view,
            observeTimeLeftUseCase = ObserveTimeLeftUseCaseImpl(
                currentTimeUseCase = ObserveCurrentTimeUseCaseImpl()
            ),
            getParisEventListUseCase = GetParisEventUseCaseImpl(
                parisEventRepo = ParisEventsRepoImpl(
                    recordsToParisEventConverter = RecordsToParisEventConverter()
                )
            )
        )
    }
}