package com.example.esieaandroid4a.presentation.creationAccount

sealed class AccountStatus

data class AccountSuccess(val email: String, val password: String, val nom: String, val prenom: String) : AccountStatus()
object AccountError : AccountStatus()