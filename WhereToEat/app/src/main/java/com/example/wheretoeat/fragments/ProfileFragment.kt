package com.example.wheretoeat.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat.R
import com.example.wheretoeat.userDatabase.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        view.button_logIn.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_logInFragment)
        }

        view.button_Profile_Edit.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment2)
        }


        //mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
       // mUserViewModel.readData.observe(viewLifecycleOwner, Observer { user->
       //     view.findViewById<TextView>(R.id.textView_Name).text = user.Name
       //     view.findViewById<TextView>(R.id.textView_Email).text = user.Email
       //     view.findViewById<TextView>(R.id.textView_Phone).text = user.Phone
       // })






        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}