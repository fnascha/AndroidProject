package com.example.wheretoeat.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.R
import com.example.wheretoeat.adapter.MyAdapter
import com.example.wheretoeat.repository.Repository
import com.example.wheretoeat.viewmodel.MainViewModel
import com.example.wheretoeat.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*

private lateinit var viewModel: MainViewModel
private val myAdapter by lazy {MyAdapter()}


class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
             container: ViewGroup?,
             savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_main, container, false)

        //setupRecycleView()

        //val repository = Repository()
        //val viewModelFactory = MainViewModelFactory(repository)

        // viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        // viewModel.myCustomPosts2.observe(viewLifecycleOwner, Observer { response ->
        // if (response.isSuccessful) {
        // myAdapter.setData()
        // }
        //
        // })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        setupRecycleView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        val options: MutableMap<String, String> = mutableMapOf()

        view.findViewById<Button>(R.id.search_button).setOnClickListener {
            options["name"] = view.findViewById<EditText>(R.id.rest_name).text.toString()
            options["city"] = view.findViewById<EditText>(R.id.city_name).text.toString()

            viewModel.getPostRest2(options)
            viewModel.myResponseRest2.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful) {
                    response.body()?.let { myAdapter.setData(it.restaurants) }
                    //Log.d("rest", response.body()?.restaurants!!.size.toString())
                } else {
                    Log.d("rest", response.code().toString())
                    //Toast.makeText(context, response.code().toString(), Toast.LENGTH_SHORT).show()
                }
            })
        }

    }




    private fun setupRecycleView() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
    }
}