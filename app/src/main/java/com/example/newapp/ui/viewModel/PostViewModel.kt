package com.example.newapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp.data.model.Post
import com.example.newapp.data.repository.PostRepository
import com.example.newapp.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    private val _postsState = MutableStateFlow<UiState<List<Post>>>(UiState.Loading)
    val postState: StateFlow<UiState<List<Post>>> = _postsState

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            _postsState.value = UiState.Loading
            try {
                val response = postRepository.getPost()
                _postsState.value = UiState.Success(response)
            } catch (e: Exception) {
                _postsState.value = UiState.Error(e.message.toString())
            }
        }
    }


}