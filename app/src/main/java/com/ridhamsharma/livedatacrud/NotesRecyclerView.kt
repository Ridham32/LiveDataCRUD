package com.ridhamsharma.livedatacrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRecyclerView (var notesList: ArrayList<NotesEntity>) : RecyclerView.Adapter<NotesRecyclerView.ViewHolder>(){
    class ViewHolder (var view: View):RecyclerView.ViewHolder(view){
        var personName= view.findViewById<TextView>(R.id.tvName)
        var personAge= view.findViewById<TextView>(R.id.tvAge)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerlistview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(notesList[position].title)
        holder.personAge.setText(notesList[position].description)
    }

}