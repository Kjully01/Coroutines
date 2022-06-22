package com.teste.excoroutinesdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.teste.excoroutinesdata.adapter.HomeAdapter
import com.teste.excoroutinesdata.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var myAdapter: HomeAdapter
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        setUp()
        observer()
    }

    private fun setUp(){
        myAdapter = HomeAdapter()
        binding.apply {
            rvHome.apply {
                adapter = myAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun observer() {
        viewModel.getDataRepository()
        viewModel.string.observe(this, Observer {
            myAdapter.addNewString(it)
        })
    }
}