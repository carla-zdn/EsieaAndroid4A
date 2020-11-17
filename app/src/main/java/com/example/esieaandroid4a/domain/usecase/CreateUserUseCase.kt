package com.example.esieaandroid4a.domain.usecase

import com.example.esieaandroid4a.data.repository.UserRepository
import com.example.esieaandroid4a.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    fun invoke(user: User){
        userRepository.createUser(user)
    }
}