package com.cengiztoru.madarchitecturesample.repository

import com.cengiztoru.madarchitecturesample.data.remote.Webservices

/**
 * Created by Cengiz TORU on 30/05/2021.
 * cengiz.toru@tsoft.com.tr
 */
//class UserRepository @Inject constructor(private val webservices: Webservices) {    // you don't need NetworkModule when use like this
class UserRepository(private val webservices: Webservices) {
    suspend fun getUser(userId: String) = webservices.getUser(userId)
}