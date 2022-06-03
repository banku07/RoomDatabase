package com.example.roomdatabase.fragments

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.R
import com.example.roomdatabase.userViewModel.UserViewModel
import com.example.roomdatabase.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding;
     val userViewModel: UserViewModel by activityViewModels();
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentTransaction","ListFragment_onCreateView")
        binding = FragmentListBinding.inflate(inflater, container, false)
        view?.setBackground(ColorDrawable(Color.TRANSPARENT));
        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(binding.recyclerView.context, LinearLayoutManager.VERTICAL))
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

//        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.readAllData.observe(viewLifecycleOwner,  {
            adapter.setData(it)
        })
        setHasOptionsMenu(true)
        return binding.root;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteAllUser()
        }
        return super.onOptionsItemSelected(item)
    }

    fun deleteAllUser(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            userViewModel.deleteAllUsers()
            Toast.makeText(requireContext(),
                " All Data Deleted Successfully ", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No"){_,_ ->
        }
        builder.setTitle("Delete All Users")
        builder.setMessage("Are u wanna delete all the Users ?")
        builder.create().show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentTransaction","ListFragment_onViewCreated")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentTransaction","ListFragment_onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentTransaction","ListFragment_onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("FragmentTransaction","ListFragment_onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("FragmentTransaction","ListFragment_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentTransaction","ListFragment_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentTransaction","ListFragment_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentTransaction","ListFragment_onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentTransaction","ListFragment_onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentTransaction","ListFragment_onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentTransaction","ListFragment_onDetach")
    }



}