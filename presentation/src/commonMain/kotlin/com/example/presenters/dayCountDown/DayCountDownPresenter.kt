package com.example.presenters.dayCountDown

import com.example.domain.dayCountDown.usecase.ObserveTimeLeftUseCase
import com.example.domain.parisEvent.usecase.GetParisEventListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DayCountDownPresenter(
    private val view: DayCountDownContract.View,
    private val observeTimeLeftUseCase: ObserveTimeLeftUseCase,
    private val getParisEventListUseCase: GetParisEventListUseCase
) : DayCountDownContract.Presenter() {

    companion object {
        const val dueDateFirstJanTwentyFifty = 2524608000000
    }

    private var viewModel = ViewModel()

    override suspend fun onStart() {
        CoroutineScope(currentCoroutineContext()).launch {
            observeTimeLeftUseCase.exeUseCase(ObserveTimeLeftUseCase.Params(dueDateFirstJanTwentyFifty))
                .collect {
                    viewModel.secondsLeftBeforeDueDate = it.seconds.toString()
                    println("marc time left ${it.seconds}")
                    invalidate()
                }
        }
        getParisEventListUseCase.exeUseCase().let {
            viewModel.parisEventText = it[0].title
            invalidate()
        }
    }

    override suspend fun doInvalidate() {
        view.displayDueDate(viewModel.dueDate)
        view.displaySecondsLeftBeforeDueDate(viewModel.secondsLeftBeforeDueDate)
        view.displayParisEvent(viewModel.parisEventText)
    }

    private class ViewModel {
        var secondsLeftBeforeDueDate: String? = null
        var dueDate: String? = null
        var parisEventText: String? = null
    }
}