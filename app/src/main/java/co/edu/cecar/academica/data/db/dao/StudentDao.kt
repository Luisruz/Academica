package co.edu.cecar.academica.data.db.dao

import androidx.room.*
import co.edu.cecar.academica.data.db.entity.StudentEntity
import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable

@Dao
interface StudentDao {
    @Query("select * from student")
    fun getStudent(): Observable<List<StudentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg students: StudentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: StudentEntity)

    @Delete
    fun delete(student: StudentEntity)

    @Update
    fun update(student: StudentEntity)
}