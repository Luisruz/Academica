package co.edu.cecar.academica.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.cecar.academica.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Referencia al StudenViewModel
        val studentViewModel = ViewModelProvider(this).get(StudenViewModel::class.java)
        //obtener estudiantes
        studentViewModel.mLiveData.observe(this, Observer { listStudent ->
            val studentAdapter = StudentAdapter(listStudent)
            recyclerViewStudent.apply {
                adapter = studentAdapter
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)

            }
        })
        studentViewModel.getStudentWithLiveData()
        Handler().postDelayed({
            studentViewModel.getStudentForLocalDatabase()
        },5000)
    }
}

