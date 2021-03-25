package com.example.presenters.dayCountDown

import com.example.presenters.common.BasePresenter

interface DayCountDownContract {

    interface View {
        fun displayDueDate(string: String?)
        fun displaySecondsLeftBeforeDueDate(string: String?)
        fun displayParisEvent(string: String?)
    }

    abstract class Presenter: BasePresenter()
}