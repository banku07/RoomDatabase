package com.example.roomdatabase.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.model.User
import com.example.roomdatabase.databinding.CustomRowBinding

/**
 * Created by Banku
 */
class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
    lateinit var binding: CustomRowBinding

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = CustomRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            with(userList.get(position)) {
                binding.firstName.text = firstName;
                binding.lastName.text = lastName
                binding.age.text = age.toString()
                binding.place.text = place.toString()
                binding.primarykey.text = id.toString()
                binding.rowLayout.setOnClickListener{
                    val action = ListFragmentDirections.actionListFragmentToUpdateFragment(this)
                    holder.itemView.findNavController().navigate(action)
                }

            }
        }
    }

    override fun getItemCount(): Int {
      return userList.size
    }

    fun setData(user:List<User>){
        this.userList = user
        notifyDataSetChanged()
    }


}