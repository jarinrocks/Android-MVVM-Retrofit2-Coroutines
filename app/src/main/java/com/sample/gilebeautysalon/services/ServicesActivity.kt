package com.sample.gilebeautysalon.services

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.gilebeautysalon.databinding.ActivityServicesBinding


class ServicesActivity : AppCompatActivity() {

    private val viewModel: ServicesViewModel by viewModels()

    private val servicesAdapter = ServicesAdapter()

    private lateinit var binding : ActivityServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServicesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        
        binding.rvServices.apply { 
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = servicesAdapter
        }

        viewModel.servicesStates.observe(this){
            when(it){
                is ServicesStates.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvErrorMessage.visibility = View.GONE
                    servicesAdapter.addServicesList(it.data,viewModel)
                }
                is ServicesStates.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvErrorMessage.visibility = View.VISIBLE
                    binding.tvErrorMessage.text = it.message
                }
                is ServicesStates.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

}