package com.example.lastversion

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun makeTime(string: String): Int {
            val time1 = string.split(":")
            return time1[0].toInt()*3600 + time1[1].toInt()*60 + time1[2].toInt()
        }


        button.setOnClickListener{
            val hour = editTextNumber.text.toString().toInt()
            val min = editTextNumber2.text.toString().toInt()
            var sec = editTextNumber3.text.toString().toInt()
            var i = Intent(applicationContext, MyBroadcastReciever::class.java)
            var pi = PendingIntent.getBroadcast(applicationContext, 111, i,0)
            var am : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            val cal = Calendar.getInstance()
            //var tday = cal.get(Calendar.DAY_OF_MONTH)
           //var tmonth = cal.get(Calendar.MONTH)
            //var tyear = cal.get(Calendar.YEAR)
            val thour = cal.get(Calendar.HOUR)
            val tmin = cal.get(Calendar.MINUTE)
            var tsec = cal.get(Calendar.SECOND)

            sec += hour*3600 + min*60
            tsec += thour*3600 + tmin*60
            sec = sec - tsec




           // var time2 = System.currentTimeMillis()/1000
           // var time3 = makeTime(sec)
           // var time = time3-time2


            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (sec*1000), pi)
            Toast.makeText(applicationContext, "Будильник прозвонит через $sec секунд", Toast.LENGTH_LONG).show()

        }
    }
}