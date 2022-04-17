package com.androiddevs.runningappyt.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // when we want to insert a run that already exists in the db, then the old run will be replaced by the new one.
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run:Run)

    /*
    var timestamp: Long = 0L,   //What time the run started
    var avgSpeedInMPH: Float = 0f,
    var distanceInMiles: Int = 0,
    var timeInMillis: Long = 0L, //how long was the run
    var caloriesBurned: Int = 0,
     */

    //The query functions don't use the 'suspend' keyword(coroutines) bc it returns a Live Data object
    //That way, you can observe live changes
    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInMPH DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMiles DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByInMilis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMilis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMiles) FROM running_table")
    fun getTotalDistanceInMiles(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedInMPH) FROM running_table")
    fun getTotalAverageSpeedInMPH(): LiveData<Float>
}