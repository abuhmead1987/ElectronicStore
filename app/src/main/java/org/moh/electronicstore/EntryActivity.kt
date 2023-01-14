package org.moh.electronicstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.moh.electronicstore.KotlinCode.*
import java.time.LocalDate
import kotlin.random.Random

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        val custList=arrayOf(Customer(1,"Ghadeer","Palestine","Ramallah"),
            Customer(2,"Mohammad","Palestine","Hebron"),
            Customer(3,"Rami","Palestine","Nablus"))
        val manufacturerList=listOf(Manufacturer(1,"Sony","Japan"),
            Manufacturer(2,"Samsung","Korea"),
            Manufacturer(3,"DELL","America"),
            Manufacturer(4,"LG","Korea"))

        findViewById<Button>(R.id.btn_save).setOnClickListener(){
            MainActivity.mboList+=Mobile("m1", "Mobile",2.1,manufacturerList[Random.nextInt(0, 3)],
                LocalDate.of(2021,10,15), custList[Random.nextInt(0, 2)],
                125.0, OperatingSystems.Windows,"6.1\"","05688888")

        }
    }
}