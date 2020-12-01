package com.example.swvlmoviesapp.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie
import kotlin.reflect.KClass

/**
 * Open base view model class to make settings in viewmodels on global level
 */
open class BaseViewModel : ViewModel() {


    /**
     * function to start activity from viewmodels
     * NOTE: For this specific example, I am using context from viewmodel to start an activity
     *       In other cases start activity should be called from activity by using mutablelive data
     *       You can also create a global mutablelive data and observe it in every activity
     * @param context
     * @param className
     * @param bundle
     */
    fun startActivity(context: Context, className: KClass<*>, bundle: Bundle? = null) {
        val intent = Intent(context, className.java)
        if (bundle != null) {
            intent.putExtra("bundle", bundle)
        }
        (context as AppCompatActivity).startActivity(intent)
    }

    /**
     * function to finish activity from viewmodel
     * @param context
     */
    fun finishActivity(context: Context) {
        (context as AppCompatActivity).finish()
    }

    companion object {
        /// making global list which is loaded one time and can be use in whole app for later use
        /// this list is loaded in main list activity
        var movieList = arrayListOf<Movie>()
    }
}