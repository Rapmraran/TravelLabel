package com.bangkit.travellabel.view.forum

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.bangkit.travellabel.data.Repository
import com.bangkit.travellabel.data.response.DiscussionsItem
import kotlinx.coroutines.launch

class ForumViewModel(private val repository: Repository) : ViewModel() {
    private var _listForum = MutableLiveData<List<DiscussionsItem>>()
    val listForum: LiveData<List<DiscussionsItem>> = _listForum


    fun getForum(token: String) {
        viewModelScope.launch {
            repository.getForum(token).collect {
                it.onSuccess {
                    _listForum.postValue(it.discussions)
                }
            }
        }
    }

}