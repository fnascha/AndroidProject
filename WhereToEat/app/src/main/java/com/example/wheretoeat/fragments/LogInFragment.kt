package com.example.wheretoeat.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat.R
import com.example.wheretoeat.activities.MainActivity
import com.example.wheretoeat.userDatabase.UserViewModel
import com.example.wheretoeat.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_log_in.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class LogInFragment : Fragment() {
    private lateinit var userView : UserViewModel
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_log_in, container, false)


        view.buttonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_logInFragment_to_editProfileFragment)

        }

        view.buttonLogin.setOnClickListener{
            findNavController().navigate(R.id.action_logInFragment_to_profileFragment)
            login()
        }



        return view
    }

    private fun login() {
        val email = editTextLoginEmail.text.toString()
        val pWord = editTextLoginPassword.text.toString()

        if(loginCheck(email, pWord)){
            userView = ViewModelProvider(this).get(UserViewModel::class.java)
            userView.readLoginData.observe(viewLifecycleOwner, Observer { user ->
                for (i in user) {
                    if (i.password.toString() == pWord && i.Email.toString() == email) {
                        Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_LONG)
                            .show()
                        viewModel = activity?.run {
                            ViewModelProviders.of(this)
                                .get(LoginViewModel::class.java)
                        } ?: throw Exception("Invalid Activity")
                        viewModel.email.value = email
                        val intent = Intent(activity, MainActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                }
            })
        }else{
            Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_LONG).show()
        }
    }


    private fun loginCheck(email: String, password: String) : Boolean {
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }




}