package com.dhana.prograssbars

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekhbar = findViewById<SeekBar>(R.id.seekbar)
        val seekbartextview = findViewById<TextView>(R.id.seekbartextview)
        val progressBar = findViewById<ProgressBar>(R.id.pbarhori)
        val btn = findViewById<Button>(R.id.uploadbtn)


        val ratingtxtview = findViewById<TextView>(R.id.ratingtextview)
        val rBar = findViewById<RatingBar>(R.id.rbar)

        rBar.setOnRatingBarChangeListener { ratingBar, rating, a ->
            ratingtxtview.setText("Rating = $rating")
        }

        seekhbar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    b: Boolean
                ) {
                    seekbartextview.setText("Value = $progress")
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            }


        )

        Thread(Runnable {
            var count = 0
            while (count <= 100) {
                count += 10
                progressBar.setProgress(count)
                Thread.sleep(1000)
            }

        }).start()

        btn.setOnClickListener {
            var pd = ProgressDialog(this)
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            pd.setTitle("Upload")
            pd.setMessage("Uploading")
            pd.show()

            Thread(
                Runnable {
                var count = 0
                while (count < 100) {
                    count += 20
                    pd.setProgress(count)
                    Thread.sleep(1000)
                    if (count >=100){
                       pd.dismiss()
                    }

                                   }




                }

            ).start()
            Toast.makeText(this,"Downloading...",Toast.LENGTH_SHORT).show()


        }


    }
}