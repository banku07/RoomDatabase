package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by Banku
 */
class MainActivity : AppCompatActivity() {
    lateinit var ActivityMainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding = com.example.roomdatabase.databinding.ActivityMainBinding.inflate(layoutInflater)
        setContentView(ActivityMainBinding.root)
        lifecycleScope.launchWhenStarted {  }

        Log.d("FragmentTransaction", "onCreate")
        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment_container))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp()||super.onSupportNavigateUp()
    }


    override fun onStart() {
        super.onStart()
        Log.d("FragmentTransaction", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentTransaction", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentTransaction", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentTransaction", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentTransaction", "onDestroy")
    }



}