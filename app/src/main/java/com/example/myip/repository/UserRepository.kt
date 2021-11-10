package com.example.myip.repository

import com.example.myip.data.User
import com.example.myip.restApi.UserApi

class UserRepository(
    private val userApi: UserApi
) {

    suspend fun getUser(): User = User(
        ip = userApi.getUser().ip,
        xForwardedFor = userApi.getUser().xForwardedFor
    )
}


