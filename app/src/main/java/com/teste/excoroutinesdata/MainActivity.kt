package com.teste.excoroutinesdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teste.excoroutinesdata.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var number : Int = 0
    private var isLoopStarted: Boolean = false

    private lateinit var myJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listener()
    }

    private fun listener(){
        binding.apply {
            btnStart.setOnClickListener {
                initLoop()
            }
            btnFinish.setOnClickListener {
                myJob.cancel()
            }
        }
    }

    private fun initLoop(){
        myJob = CoroutineScope(Dispatchers.IO).launch{
            while(true){
                number++
                delay(1000)
                withContext(Dispatchers.Main){
                    binding.textView.text = "$number"
                }
            }
        }
    }
}