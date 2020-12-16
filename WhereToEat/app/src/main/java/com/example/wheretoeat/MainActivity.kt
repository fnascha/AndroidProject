package com.example.wheretoeat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wheretoeat.databinding.ActivityMainBinding
import com.example.wheretoeat.repository.Repository
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel :: class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response",response.body()?.cities.toString())
                //Log.d("Response",response.body()?.restaurant.toString())
                //textView.text = response.body().cities!!
                Log.d("Response",response.body()?.restaurants.toString() )
            }
            else{
                Log.d("Response",response.errorBody().toString())
                //textView.text = response.code().toString()
            }


        })

        bottomNav.setOnNavigationItemSelectedListener(navListener)
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                MainFragment()
            ).commit()
        }
    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> selectedFragment = MainFragment()
                R.id.nav_profile -> selectedFragment = ProfileFragment()
                R.id.nav_detailscreen -> selectedFragment =DetailsFragment()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    selectedFragment
                ).commit()
            }
            true
        }

}