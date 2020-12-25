package com.example.esieaandroid4a.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esieaandroid4a.domain.entity.User
import com.example.esieaandroid4a.domain.usecase.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateAccountViewModel(private val createUserUseCase: CreateUserUseCase) : ViewModel(){

    fun onClicked(user: User){
        viewModelScope.launch(Dispatchers.IO){
            createUserUseCase.invoke(user)
        }
    }
}