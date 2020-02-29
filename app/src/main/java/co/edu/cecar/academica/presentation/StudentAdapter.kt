package co.edu.cecar.academica.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.cecar.academica.R
import co.edu.cecar.academica.presentation.model.Student
import kotlinx.android.synthetic.main.item_student_layout.view.*

class StudentAdapter(val data: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.txtName.text = item.name
    }

    inner class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
