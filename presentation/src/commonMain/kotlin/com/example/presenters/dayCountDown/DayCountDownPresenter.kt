package com.example.presenters.dayCountDown

class DayCountDownPresenter(
    private val view: DayCountDownContract.View
) : DayCountDownContract.Presenter{

    override fun onViewStart() {
        view.displayDaysLeft("12")
        view.displayDueDate("07/09/2021")
    }

    override fun onViewStop() {
    }
}