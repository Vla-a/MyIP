package com.example.myip

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myip.repository.UserRepository
import com.example.myip.restApi.UserApi
import com.example.myip.viewModel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MySuperApp : Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MySuperApp)
            modules(listOf(repositoryModule, viewModels, userApi))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val viewModels = module {
        viewModel { MainViewModel(get()) }

    }

    private val repositoryModule = module { //создаем репозитории

        factory { UserRepository(get()) }

    }

    private val userApi = module {
        single { UserApi.get() }
    }


}