package com.deuk.daggertemplate04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.deuk.daggertemplate04.di.MyApplication
import com.deuk.daggertemplate04.room.Repository
import com.deuk.daggertemplate04.room.User

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener { addUser() }
        getButton.setOnClickListener { getUsers() }
    }

    private fun addUser() {
        lifecycleScope.launch(Dispatchers.IO) {
            repository.insertUser(User(name = "John", age = 200))
            showToast("User added!")
        }
    }

    private fun getUsers() {
        lifecycleScope.launch(Dispatchers.IO) {
            val users = repository.getUsers()
            updateText(users.size)
            showToast("Fetched users!")
        }
    }

    private suspend fun updateText(usersSize: Int) {
        withContext(Dispatchers.Main) {
            textView.text = usersSize.toString()
        }
    }

    private suspend fun showToast(message: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }
}