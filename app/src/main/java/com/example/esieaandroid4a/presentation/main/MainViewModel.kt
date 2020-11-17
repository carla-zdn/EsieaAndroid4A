package com.example.esieaandroid4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esieaandroid4a.domain.entity.User
import com.example.esieaandroid4a.domain.usecase.CreateUserUseCase
import com.example.esieaandroid4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val counter : MutableLiveData<Int> = MutableLiveData()

    init{
        counter.value = 0
    }

    fun onClickedIncrement() {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test"))
            val user = getUserUseCase.invoke("test")
        }
    }
}