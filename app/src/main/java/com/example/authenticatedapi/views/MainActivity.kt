package com.example.authenticatedapi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.authenticatedapi.R
import com.example.authenticatedapi.adapters.MainAdapter
import com.example.authenticatedapi.models.Users
import com.example.authenticatedapi.utils.Resource
import com.example.authenticatedapi.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy{
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.usersLiveDatas.observe(this,{characters->
            processResponse(characters)
            Log.i("main", characters.toString())


        })
    }

    private fun processResponse(state: Resource<List<Users>?>){
        when(state){
            is Resource.Loading->{
                progressBar.visibility=VISIBLE
            }
            is Resource.Success->{
                progressBar.visibility= View.GONE
                if (state.data!=null){
                    val adapters= MainAdapter(state.data)
                    mainRecycler.apply {
                        adapter=adapters
                        layoutManager=LinearLayoutManager(this@MainActivity)
                    }

                }

            }
            is Resource.Error->{
                progressBar.visibility=View.GONE
                val view=progressBar.rootView
                Snackbar.make(view, state.message!!,Snackbar.LENGTH_LONG).show()

            }

        }
    }
}