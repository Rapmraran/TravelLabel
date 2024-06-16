package com.bangkit.travellabel.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.travellabel.data.Repository
import com.bangkit.travellabel.view.forum.ForumViewModel
import com.coba.storyapp.di.Injection

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ForumViewModel::class.java) -> {
                ForumViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

//    companion object {
//        @Volatile
//        private var INSTANCE: ViewModelFactory? = null
//        @JvmStatic
//        fun getInstance(context: Context): ViewModelFactory {
//            if (INSTANCE == null) {
//                synchronized(ViewModelFactory::class.java) {
//                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
//                }
//            }
//            return INSTANCE as ViewModelFactory
//        }
//    }

    companion object {
        fun getInstance(context: Context) = ViewModelFactory(Injection.provideRepository(context))
    }
}