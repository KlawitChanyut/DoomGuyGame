package klawit.example.doomguygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var score : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        object : CountDownTimer(10000,1000) {
            override fun onTick(p0: Long) {
                Text_time.text = "Time: " + p0 / 1000
            }

            override fun onFinish() {
                Text_time.text = "Time's off"
            }
        }.start()
    }

    fun increaseScore(view: View) {
        score++

        Text_score.text = "Score: " + score

    }
}