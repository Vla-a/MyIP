package com.example.myip.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myip.data.User
import com.example.myip.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent


@RequiresApi(Build.VERSION_CODES.O)
@KoinApiExtension
class MainViewModel(
    private val userRepository: UserRepository

) : ViewModel(), KoinComponent {

    val userLiveData: MutableLiveData<User> = MutableLiveData()

    init {
        try {
            viewModelScope.launch {
                val result = withContext(Dispatchers.IO) {
                    userRepository.getUser()
                }
                userLiveData.postValue(result)
            }

        } catch (e: Exception) {
            print(e)
        }
    }
}




