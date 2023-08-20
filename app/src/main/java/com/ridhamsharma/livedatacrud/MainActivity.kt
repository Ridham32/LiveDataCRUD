package com.ridhamsharma.livedatacrud

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridhamsharma.livedatacrud.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),RecyclerInterface {
    lateinit var binding: ActivityMainBinding
    lateinit var layoutManager: LinearLayoutManager
    lateinit var viewModel: ViewModel
    lateinit var notesDb: NotesDb
    lateinit var notesEntityList: ArrayList<NotesEntity>
     var adapter:RecyclerViewAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager= LinearLayoutManager(this)
        viewModel=ViewModelProvider(this).get(ViewModel::class.java)

        adapter = RecyclerViewAdapter(notesEntityList,this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        viewModel.notesEntity.observe(this){
            for(notesEntity in it){
                System.out.println("in list entity ${notesEntity.id}")
            }


        }




    }

    override fun onDeleteClick(position: Int) {
    }

    override fun onUpdateClick(position: Int) {
    }
}