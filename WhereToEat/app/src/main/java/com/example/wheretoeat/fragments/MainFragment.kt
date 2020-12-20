package com.example.wheretoeat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretoeat.R
import com.example.wheretoeat.adapter.MyAdapter
import com.example.wheretoeat.repository.Repository
import com.example.wheretoeat.viewmodel.MainViewModel
import com.example.wheretoeat.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*

private lateinit var viewModel: MainViewModel
private val myAdapter by lazy{MyAdapter()}

class MainFragment : Fragment() {
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        setupRecycleView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel :: class.java)

        viewModel.myCustomPosts.observe(viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful){
                //myAdapter.setData()
            }

        })


        return view
    }


    private fun setupRecycleView(){
        recyclerView.adapter=myAdapter
       // recyclerView.layoutManager = LinearLayoutManager(this)

    }




}