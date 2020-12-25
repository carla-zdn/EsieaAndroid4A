package com.example.esieaandroid4a.domain.usecase

import com.example.esieaandroid4a.data.repository.UserRepository
import com.example.esieaandroid4a.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    fun invoke(email: String) : User?{
        return userRepository.getUser(email)
    }
}