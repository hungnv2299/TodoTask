package com.hung.todotask

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModels {
        TaskViewModelFactory((application as TasksApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rcv_task)
        val adapter = TaskListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        findViewById<FloatingActionButton>(R.id.bt_add).setOnClickListener() {
            if (supportFragmentManager.findFragmentById(R.id.fragment) == null) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<Fragment_Add>(R.id.fragment)
                }
            }
        }

        findViewById<Button>(R.id.bt_complete).setOnClickListener() {
            if (supportFragmentManager.findFragmentById(R.id.fragment) == null) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<Fragment_Complete>(R.id.fragment)
                }
            }
        }

        taskViewModel.allTask.observe(this){tasks ->
            tasks.let { adapter.submitList(it) }
        }
    }


    override fun onBackPressed() {
        getSupportFragmentManager().beginTransaction()
            .remove(getSupportFragmentManager().findFragmentById(R.id.fragment)!!).commit()
    }
}


//        taskViewModel.allTask.observe(owner = this) { tasks ->
//            // Update the cached copy of the words in the adapter.
//            tasks.let { adapter.submitList(it) }
//        }


//    private fun obtainViewFragment() =
//        supportFragmentManager.findFragmentById(R.id.fragment)
//            ?: Fragment_Add.newInstance()




