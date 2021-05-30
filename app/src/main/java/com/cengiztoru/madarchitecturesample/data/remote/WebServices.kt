package com.cengiztoru.madarchitecturesample.data.remote

import com.cengiztoru.madarchitecturesample.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Cengiz TORU on 30/05/2021.
 * cengiz.toru@tsoft.com.tr
 */

interface Webservices {
    @GET("/users/{user}")
    suspend fun getUser(@Path("user") userId: String): User
}