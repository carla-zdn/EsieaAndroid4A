package com.example.esieaandroid4a.presentation.recyclerView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esieaandroid4a.domain.usecase.GetUserUseCase
import com.example.esieaandroid4a.presentation.creationAccount.AccountError
import com.example.esieaandroid4a.presentation.creationAccount.AccountStatus
import com.example.esieaandroid4a.presentation.creationAccount.AccountSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondViewModel (
        private val getUserUseCase: GetUserUseCase
) : ViewModel(){
}