package co.edu.cecar.academica.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import co.edu.cecar.academica.data.db.dao.StudentDao
import co.edu.cecar.academica.data.db.entity.StudentEntity

@Database(
    entities = arrayOf(StudentEntity::class),
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}
