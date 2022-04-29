package com.example.testappforoptima

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetAddress
import java.net.UnknownHostException

suspend fun internetAvailability(): Boolean {
    return try {
        withContext(Dispatchers.Default) { InetAddress.getByName("mail.ru") }
        true
    } catch (e: UnknownHostException) {
        false
    }
}