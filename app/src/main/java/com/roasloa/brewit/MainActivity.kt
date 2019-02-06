package com.roasloa.brewit

import android.graphics.Canvas
import android.os.Bundle
import android.os.CountDownTimer
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.roasloa.brewit.Models.RadialProgressBar

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val newTimer = timer(30000,1000)




    private fun timer(millisInFuture: Long, countDownInterval: Long): CountDownTimer{
        return object: CountDownTimer(millisInFuture, countDownInterval){
            override fun onFinish() {
//                println("done")
                radialProgressBar.progress = 0
            }

            override fun onTick(millisUntilFinished: Long) {
//                println("seconds remaining: " + millisUntilFinished / 1000)

                val percentageInFuture = millisInFuture/100

                var percentage: Long = millisUntilFinished/percentageInFuture
                println(percentage)
                radialProgressBar.progress = percentage.toInt()


            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        stopButton.visibility = View.INVISIBLE








    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun startButtonClicked(view: View){
        startButton.visibility = View.INVISIBLE
        stopButton.visibility = View.VISIBLE

        newTimer.start()


    }


    fun stopButtonClicked(view: View){
        newTimer.cancel()

        radialProgressBar.progress = 100

        startButton.visibility = View.VISIBLE
        stopButton.visibility = View.INVISIBLE
    }







}
