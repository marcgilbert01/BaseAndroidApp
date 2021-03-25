package com.example.presenters.dayCountDown

import com.example.domain.dayCountDown.usecase.ObserveTimeLeftUseCase
import com.example.domain.parisEvent.usecase.GetParisEventListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
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
        CoroutineScope(Dispatchers.Default).launch {
            observeTimeLeftUseCase.exeUseCase(ObserveTimeLeftUseCase.Params(dueDateFirstJanTwentyFifty))
                .collect {
                    viewModel.secondsLeftBeforeDueDate.emit(it.seconds.toString())
                }
        }
        getParisEventListUseCase.exeUseCase().let { parisEventList ->
            parisEventList[0].title?.let {
                viewModel.parisEventText.emit(it)
            }
        }
    }

    override suspend fun listenToViewModelAndUpdateUi() {
        listenTo(viewModel.secondsLeftBeforeDueDate) {
            view.displaySecondsLeftBeforeDueDate(it)
        }
        listenTo(viewModel.dueDate) {
            view.displayDueDate(it)
        }
        listenTo(viewModel.parisEventText) {
            view.displayParisEvent(it)
        }
    }

    private class ViewModel {
        var secondsLeftBeforeDueDate = MutableStateFlow("")
        var dueDate = MutableStateFlow("")
        var parisEventText = MutableStateFlow("")
    }
}