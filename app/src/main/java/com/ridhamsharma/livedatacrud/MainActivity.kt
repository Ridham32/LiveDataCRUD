package com.ridhamsharma.livedatacrud

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
    lateinit var notesEntity: ArrayList<NotesEntity>
     var adapter:NotesRecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this).get(ViewModel::class.java)
        adapter = NotesRecyclerView(notesEntity)




    }

    override fun onDeleteClick(position: Int) {
    }

    override fun onUpdateClick(position: Int) {
    }
}