package com.ridhamsharma.livedatacrud

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridhamsharma.livedatacrud.databinding.ActivityMainBinding
import com.ridhamsharma.livedatacrud.databinding.CustomfabBinding


class MainActivity : AppCompatActivity(),RecyclerInterface {
    lateinit var binding: ActivityMainBinding
    lateinit var layoutManager: LinearLayoutManager
    lateinit var viewModel: NotesViewModel
    lateinit var notesDb: NotesDb
     var notesEntityList: ArrayList<NotesEntity> = ArrayList()
     var adapter:RecyclerViewAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
        notesDb = NotesDb.getDatabase(this)

        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        adapter = RecyclerViewAdapter(notesEntityList, this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        viewModel.notesEntity.observe(this) {
            adapter?.notesList?.clear()
            adapter?.notesList?.addAll(it)
            adapter?.notifyDataSetChanged()

          /*  for (notesEntity in it) {
                System.out.println("notes entity ${notesEntity.id}")
                System.out.println("notes entity ${notesEntity.name}")
                System.out.println("notes entity ${notesEntity.age}")
            }*/
        }

        binding.fab.setOnClickListener {
            var dialog = Dialog(this)
            var dialogBinding = CustomfabBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.getWindow()?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialogBinding.btnAdd.setOnClickListener {
                if (dialogBinding.etNameCustom.text.toString().isNullOrEmpty()) {
                    dialogBinding.etNameCustom.error = "Enter Name"
                } else if (dialogBinding.etAgeCustom.text.toString().isNullOrEmpty()) {
                    dialogBinding.etAgeCustom.error = "Enter Age"
                } else {
                    viewModel.addNotes(NotesEntity(
                        name = dialogBinding.etNameCustom.text.toString(),
                    age = dialogBinding.etAgeCustom.text.toString()),
                        )

                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }


    override fun onDeleteClick(position: Int){
        viewModel.Delete(notesEntityList[position])
    }

    override fun onUpdateClick(position: Int) {
        var dialog = Dialog(this)
        var dialogBinding = CustomfabBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.getWindow()?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialogBinding.btnAdd.setOnClickListener {
            if (dialogBinding.etNameCustom.text.toString().isNullOrEmpty()) {
                dialogBinding.etNameCustom.error = "Enter Name"
            } else if (dialogBinding.etAgeCustom.text.toString().isNullOrEmpty()) {
                dialogBinding.etAgeCustom.error = "Enter Age"
            } else {
                viewModel.Update(NotesEntity(
                    id = notesEntityList[position].id,
                    name = dialogBinding.etNameCustom.text.toString(),
                    age = dialogBinding.etAgeCustom.text.toString()),

                )

                dialog.dismiss()
            }
        }
        dialog.show()
    }

    }
