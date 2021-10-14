package com.tuwaiq.husam.intentproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // We declared variables with lateinit because we want to assign them later
    private lateinit var buttonNextPage: Button
    private lateinit var myText: TextView

    // onCreate is a method that will be called when we are using startActivity() function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView is to inflate (show) our xml file (activity_main.xml) on top of the activity
        setContentView(R.layout.activity_main)
        /* We assigned variables their object values so we can have complete control for example:
         myText have full control of textView from activity_main.xml , we can change text , textSize and more   */
        buttonNextPage = findViewById(R.id.btnNextActivity)
        myText = findViewById(R.id.textView)

        // setOnClickListener is a function that will not run until the button is clicked
        buttonNextPage.setOnClickListener {
            /* Intent object like we said is the contract or piece of paper that has the information
               that the ActivityManager (Operating System) needs in order for him to startActivity */
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("basha", "hello ya Basha")
            // startActivity(i)
            startActivityForResult(i, 3) // requestCode is like the pin just to make sure he is the one who send it
        }

    }

    /* if we used startActivityForResult(), The MainActivity will stay in the Background
       and will not terminate and add to stack (history) like startActivity
       , MainActivity will wait for response from the SecondActivity */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3) { // to check the pin
            if (resultCode == RESULT_OK) { // to check if the response was RESULT_OK then do my code inside
                myText.text = "Everything is ok"
                myText.setTextSize(50f)
            }
        }
    }

}