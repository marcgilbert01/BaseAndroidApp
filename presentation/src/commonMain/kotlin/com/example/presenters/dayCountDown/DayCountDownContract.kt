package com.example.presenters.dayCountDown

interface DayCountDownContract {

    interface View {
        fun displayDueDate(string: String)
        fun displayDaysLeft(string: String)
    }

    interface Presenter {
        fun onViewStart()
        fun onViewStop()
    }
}