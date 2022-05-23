package com.example.lastversion

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alarm_on.*

class AlarmOnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_on)

        var mp = MediaPlayer.create(applicationContext, R.raw.skala)
        mp.start()

        button2.setOnClickListener{
            mp.stop()
        }
    }
}