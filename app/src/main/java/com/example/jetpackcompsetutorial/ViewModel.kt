package com.example.jetpackcompsetutorial

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    internal var subTimerState: ((Long) -> Unit)? = null
    private var timerState: Long = 0L

    internal fun updateTimerState() {
        timerState++
        subTimerState?.invoke(timerState)
    }

}
