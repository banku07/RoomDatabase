package com.example.roomdatabase.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.model.User
import com.example.roomdatabase.R
import com.example.roomdatabase.userViewModel.UserViewModel
import com.example.roomdatabase.databinding.FragmentAddBinding


/**
 * Created by Banku
 */
class AddFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentTransaction", "AddFragment_onViewCreated")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentTransaction", "AddFragment_onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentTransaction", "AddFragment_onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("FragmentTransaction", "AddFragment_onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("FragmentTransaction", "AddFragment_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentTransaction", "AddFragment_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentTransaction", "AddFragment_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentTransaction", "AddFragment_onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentTransaction", "AddFragment_onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentTransaction", "AddFragment_onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentTransaction", "AddFragment_onDetach")
    }

    lateinit var binding: FragmentAddBinding;
    val userViewModel: UserViewModel by activityViewModels();
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentTransaction", "AddFragment_onCreateView")
        binding = FragmentAddBinding.inflate(inflater, container, false)
//        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.button.setOnClickListener {
            insertDataToDataBase()
        }
        return binding.root
    }


    private fun insertDataToDataBase() {
        val firstName = binding.firstName.text.toString();
        val lastName = binding.lastName.text.toString()
        val age = binding.age.text
        val place = binding.place.text.toString()
        if (inputCheck(firstName, lastName, age)) {
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()), place)
            userViewModel.addUser(user)
            findNavController().navigate(R.id.action_addFragment_to_listFragment2)
            Toast.makeText(
                requireContext(),
                "Data Enter Successfully", Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                requireContext(),
                "Please enter all the Fields", Toast.LENGTH_LONG
            ).show()
        }

    }

    fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) &&
                age.isEmpty())
    }

}