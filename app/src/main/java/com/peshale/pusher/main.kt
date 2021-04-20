package com.peshale.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "id": 1,
          "userName": "Alexander",
           "text": "Based on the best-selling sci-fi trilogy of the same name, Chaos Walking is finally coming to theaters this March, a solid two years after it was originally set to release in 2019. Its premise is simple: a woman-less planet gets an alien visitor (Daisy Ridley) who must endure a world where all men’s thoughts are on display. I have so many jokes, but let’s wait and see how this one plays out.r" 
        }""".trimIndent())
        .setToken("")
        .build()

    FirebaseMessaging.getInstance().send(message)
}