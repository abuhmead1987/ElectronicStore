package org.moh.electronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.moh.electronicstore.KotlinCode.Mobile

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_addmob_activity=findViewById<Button>(R.id.btn_addmobile)
        btn_addmob_activity.setOnClickListener(){
            startActivity(Intent(this,EntryActivity::class.java))
        }

        findViewById<Button>(R.id.btn_showmobiles).setOnClickListener(){
            startActivity(Intent(this,DataShow::class.java))
        }
        findViewById<Button>(R.id.btn_browser).setOnClickListener(){
            startActivity(Intent(this,BrowserActivity::class.java))
        }

        //This is a comment

    }
    companion object{
        var mboList=listOf<Mobile>()
    }
}