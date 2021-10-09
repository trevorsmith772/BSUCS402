package com.example.a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.R.id
import android.app.AlertDialog



class MainActivity : AppCompatActivity() {
    var acount = 0
    private lateinit var kRecyclerView: RecyclerView
    val koffeeList = arrayListOf<String>("Kona","Arabic", "Robusta","Sumatra","Kona", "Arabic", "Robusta","Sumatra","Kona","Arabic", "Robusta","Sumatra","Kona")
    val skoffeeList = arrayListOf<Boolean>(false,false,false,false,false,false,false,false,false,false,false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kRecyclerView =
            findViewById(R.id.coffee_recycler_view) as RecyclerView
        kRecyclerView.layoutManager = LinearLayoutManager(this)

        //insert adapter
        val kadapter: KAdapter  = KAdapter(this, koffeeList, skoffeeList)

        kRecyclerView.setAdapter(kadapter)

        val addbutton: Button = findViewById(R.id.addbutton)
        addbutton.setOnClickListener {
            acount += 1
            skoffeeList.add(false)
            koffeeList.add("NewKoffee " + acount)
            kadapter.notifyDataSetChanged()
        }
        val delbutton: Button = findViewById(R.id.delbutton)
        delbutton.setOnClickListener {
            for(i in skoffeeList.size downTo 1){
                if (skoffeeList[i - 1]){
                    skoffeeList.removeAt(i - 1)
                    koffeeList.removeAt(i - 1)
                }
            }
            kadapter.notifyDataSetChanged()
        }
        val joinbutton: Button = findViewById(R.id.joinbutton)
        var indeces = arrayListOf<Int>()
        joinbutton.setOnClickListener {
            for(i in 0..skoffeeList.size-1){
                if (skoffeeList[i]){
                    indeces.add(i)
                }
            }
            var concatString: String = koffeeList[indeces.get(0)]
            for(i in 1..indeces.size-1){
                concatString += koffeeList[indeces.get(i)]
                koffeeList.removeAt(indeces.get(i))
                skoffeeList.removeAt(indeces.get(i))
                indeces.removeAt(i)
            }
            koffeeList[indeces.get(0)] = concatString
            indeces.removeAt(0)
            kadapter.notifyDataSetChanged()
        }
        val splitbutton: Button = findViewById(R.id.splitbutton)
        splitbutton.setOnClickListener {
            for (i in skoffeeList.size-1 downTo 0) {
                if (skoffeeList[i]) {
                    skoffeeList.add(i, false)
                    var txtstring = koffeeList[i]
                    var prestring = txtstring
                    var poststring = txtstring
                    koffeeList[i] = prestring
                    koffeeList.add(i, poststring)
                }
            }
            kadapter.notifyDataSetChanged()
        }
    }
}
//5 lines of code for add and delete (each)