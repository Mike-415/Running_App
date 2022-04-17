package com.androiddevs.runningappyt.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

//define the entity(aka a Table) for Room
@Entity(tableName = "running_table")
data class Run(
    var img: Bitmap? = null,
    var timestamp: Long = 0L,   //What time the run started
    var avgSpeedInMPH: Float = 0f,
    var distanceInMiles: Int = 0,
    var timeInMillis: Long = 0L, //how long was the run
    var caloriesBurned: Int = 0,
) {
    //We put the primary key within the class
    // body bc Room will automatically create it
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}