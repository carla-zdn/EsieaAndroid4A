package com.example.esieaandroid4a.injection

import android.content.Context
import androidx.room.Room
import com.example.esieaandroid4a.data.local.AppDatabase
import com.example.esieaandroid4a.data.local.DatabaseDao
import com.example.esieaandroid4a.data.repository.UserRepository
import com.example.esieaandroid4a.domain.usecase.CreateUserUseCase
import com.example.esieaandroid4a.domain.usecase.GetUserUseCase
import com.example.esieaandroid4a.presentation.main.CreateAccountViewModel
import com.example.esieaandroid4a.presentation.main.MainViewModel
import com.example.esieaandroid4a.presentation.main.SecondViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module {
    factory { MainViewModel(get()) }
    factory { CreateAccountViewModel(get()) }
    factory { SecondViewModel(get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get())}
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDatabase(androidContext())}
}

fun createDatabase(context: Context): DatabaseDao{
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
