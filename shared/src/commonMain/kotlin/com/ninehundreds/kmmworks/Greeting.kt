package com.ninehundreds.kmmworks

class Greeting {
    fun greet(): String {
        return "Hello, ${Platform().platform}!"
    }
}