package com.example.wheretoeat.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat.R
import com.example.wheretoeat.userDatabase.UserDatas
import com.example.wheretoeat.userDatabase.UserViewModel
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*
import kotlinx.android.synthetic.main.fragment_log_in.view.*
import kotlinx.android.synthetic.main.fragment_log_in.view.buttonRegister
import org.w3c.dom.Text


class EditProfileFragment : Fragment() {

    private lateinit var editUserViewModel :UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

        editUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)




        view.button_submit_Profile_edit.setOnClickListener{
            updateProfile()
            findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)

        }


        return view
    }

    private fun updateProfile() {
        val name = view?.findViewById<EditText>(R.id.editText_Name)?.text.toString()
        val email = view?.findViewById<EditText>(R.id.editText_Email)?.text.toString()
        val phoneNum = view?.findViewById<EditText>(R.id.editText_Phone)?.text.toString()
        val password = view?.findViewById<EditText>(R.id.editText_Password)?.text.toString()


        if (inputcheck(name, email, phoneNum)) {
            val updateUser = UserDatas(1,name,email,phoneNum,password)

            editUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(),"Updated Successfull",Toast.LENGTH_LONG).show()

        }

        else{
            Toast.makeText(requireContext(),"Updated Unsuccessfull!",Toast.LENGTH_LONG).show()
        }


    }

    private fun inputcheck(name: String,email: String, phoneNum : String) : Boolean{
        return !(TextUtils.isEmpty(name)) or TextUtils.isEmpty(email) or TextUtils.isEmpty((phoneNum))
    }




}