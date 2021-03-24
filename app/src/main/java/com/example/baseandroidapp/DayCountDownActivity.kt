package com.example.baseandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.presenters.dayCountDown.DayCountDownContract

class DayCountDownActivity : AppCompatActivity(), DayCountDownContract.View {

    private var presenter: DayCountDownContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_count_down)
        presenter = BaseAndroidApp.instance.presenterFactory.createDayCountDownPresenter(this)
    }

    override fun onStart() {
        super.onStart()
        presenter?.onViewStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onViewStop()
    }

    override fun displayDueDate(string: String?) {
        findViewById<TextView>(R.id.due_date_text_view).text = string
    }

    override fun displaySecondsLeftBeforeDueDate(string: String?) {
        findViewById<TextView>(R.id.second_left_text_view).text = string
    }

    override fun displayParisEvent(string: String?) {
        findViewById<TextView>(R.id.parisEventTitle).text = string
    }
}