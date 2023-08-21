package com.ridhamsharma.livedatacrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (var notesList: ArrayList<NotesEntity>,var recyclerInterface:RecyclerInterface) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder (var view: View):RecyclerView.ViewHolder(view){
        var personName= view.findViewById<TextView>(R.id.tvName)
        var personAge= view.findViewById<TextView>(R.id.tvAge)
        var btnDelete = view.findViewById<Button>(R.id.btnDelete)
        var btnUpdate= view.findViewById<Button>(R.id.btnUpdate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerlistview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(notesList[position].name)
        holder.personAge.setText(notesList[position].age)
        holder.btnDelete.setOnClickListener{
            recyclerInterface.onDeleteClick(position)
        }
        holder.btnUpdate.setOnClickListener{
            recyclerInterface.onUpdateClick(position)
        }

    }

}