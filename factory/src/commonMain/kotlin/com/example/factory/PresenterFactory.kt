package com.example.factory

import com.example.data.parisEvent.ParisEventsRepoImpl
import com.example.data.parisEvent.RecordsToParisEventConverter
import com.example.domain.dayCountDown.usecase.ObserveCurrentTimeUseCaseImplCo
import com.example.domain.dayCountDown.usecase.ObserveTimeLeftUseCaseCoImpl
import com.example.domain.parisEvent.usecase.GetParisEventUseCaseImplCo
import com.example.presenters.dayCountDown.DayCountDownContract
import com.example.presenters.dayCountDown.DayCountDownPresenter

class PresenterFactory {

    fun createDayCountDownPresenter(view: DayCountDownContract.View) : DayCountDownContract.Presenter {
        return DayCountDownPresenter(
            view = view,
            observeTimeLeftUseCase = ObserveTimeLeftUseCaseCoImpl(
                currentTimeUseCase = ObserveCurrentTimeUseCaseImplCo()
            ),
            getParisEventListUseCase = GetParisEventUseCaseImplCo(
                parisEventRepo = ParisEventsRepoImpl(
                    recordsToParisEventConverter = RecordsToParisEventConverter()
                )
            )
        )
    }
}