package klawit.example.doomguygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var score : Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable : Runnable = Runnable {  }

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
                handler.removeCallbacks(runnable)
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
            }
        }.start()
    }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val index = random.nextInt(8-0)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable, 500)

            }
        }

        handler.post(runnable)

    }

    fun increaseScore(view: View) {
        score++

        Text_score.text = "Score: " + score
    }
}