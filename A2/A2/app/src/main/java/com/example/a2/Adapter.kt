package com.example.a2

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public class KAdapter(context: Context, var coffee: ArrayList<String>, var scoffee: ArrayList<Boolean>)
    : RecyclerView.Adapter<KAdapter.KoffeeHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : KAdapter.KoffeeHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false)
        return KoffeeHolder(view)
    }

    override fun getItemCount() = coffee.size

    override fun onBindViewHolder(holder: KoffeeHolder, position: Int) {
        val acoffee = coffee[position]
        holder.apply {
            titleTextView.text = acoffee
            var sscolor = "#ffffff"
            if (scoffee[position]) {
                sscolor = "#cccccc"
            }
            titleTextView.setBackgroundColor(Color.parseColor(sscolor))
        }
    }
    inner class KoffeeHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {
        val titleTextView: TextView = view.findViewById(R.id.coffee_name)
        var kSelect: Boolean = false
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View) {
            //toggle selection
            var apos = getBindingAdapterPosition()

            kSelect = scoffee[apos]
            kSelect = !kSelect
            scoffee[apos] = kSelect
            var sscolor = "#ffffff"
            if (kSelect) {
                sscolor = "#cccccc"
            }
            titleTextView.setBackgroundColor(Color.parseColor(sscolor))
        }
    }
}