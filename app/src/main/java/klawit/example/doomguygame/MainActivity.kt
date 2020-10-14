package klawit.example.doomguygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var score : Int = 0
    var imageArray = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        imageArray = arrayListOf(doom1,doom2,doom3,doom4,doom5,doom6,doom7,doom8,doom9)

        hideImages()

        object : CountDownTimer(10000,1000) {
            override fun onTick(p0: Long) {
                Text_time.text = "Time: " + p0 / 1000
            }

            override fun onFinish() {
                Text_time.text = "Time's off"
            }
        }.start()
    }

    fun hideImages() {

        for (image in imageArray) {
            image.visibility = View.INVISIBLE
        }
    }

    fun increaseScore(view: View) {
        score++

        Text_score.text = "Score: " + score
    }
}