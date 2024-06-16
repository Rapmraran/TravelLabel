package com.bangkit.travellabel.view.forum

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangkit.travellabel.R
import com.bangkit.travellabel.databinding.ActivityForumBinding

class ForumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityForumBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.apply {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { textView, actionId, event ->
                searchBar.setText(searchView.text)
                searchView.hide()
//                teks = searchView.text.toString()
//                search()
                true
            }
        }
    }
}