package com.example.cryptotrackerkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform