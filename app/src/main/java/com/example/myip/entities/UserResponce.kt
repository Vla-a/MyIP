package com.example.myip.entities

import com.google.gson.annotations.SerializedName


class UserResponce(

    @SerializedName("ip") val ip: String,
    @SerializedName("xForwardedFor") val xForwardedFor: String
)
