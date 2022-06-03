package com.example.roomdatabase.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.FragmentUpdateBinding
import com.example.roomdatabase.model.User
import com.example.roomdatabase.userViewModel.UserViewModel



/**
 * Created by Banku
 */
/**
 * A simple [Fragment] subclass.
 * Use the [UpdateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateFragment : Fragment() {
    lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    val userViewModel: UserViewModel by activityViewModels();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
//        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.updateAge.setText(args.currentUser.age.toString())
        binding.updatefirstName.setText(args.currentUser.firstName)
        binding.updatelastName.setText(args.currentUser.lastName)
        binding.place.setText(args.currentUser.place)
        binding.updateButton.setOnClickListener {
            UpdateItem()
        }
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }


    fun UpdateItem() {
        val firstName = binding.updatefirstName.text.toString();
        val lastName = binding.updatelastName.text.toString()
        val age = Integer.parseInt(binding.updateAge.text.toString())
        val place = binding.place.text.toString()
        if (inputCheck(firstName, lastName, binding.updateAge.text)) {
            val updatedUser = User(args.currentUser.id, firstName, lastName, age, place)
            userViewModel.updateUser(updatedUser)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(
                requireContext(),
                "Data Updated Successfully", Toast.LENGTH_LONG
            ).show()
        }
    }

    fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) &&
                age.isEmpty())
    }

    fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            userViewModel.deleteUser(args.currentUser)
            Toast.makeText(
                requireContext(),
                "Data Deleted Successfully ${args.currentUser.firstName}", Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ ->
        }
        builder.setTitle("Delete ${args.currentUser.firstName}")
        builder.setMessage("Are u wanna delete ${args.currentUser.firstName}")
        builder.create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

}