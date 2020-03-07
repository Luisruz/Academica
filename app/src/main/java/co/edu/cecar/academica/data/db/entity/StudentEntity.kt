package co.edu.cecar.academica.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentEntity(
    @PrimaryKey val id: Int,
   // @ColumnInfo(name = "name_student")
    val name: String

)