package com.example.lab63

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.lab63.databinding.ActivityMainBinding

var contacts = arrayListOf<Contact>()

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contacts = arrayListOf(
            Contact("Harry", "Potter", "1", "TheBoyWhoLived@gmail.com", "62442", R.mipmap.emoticon1_foreground),
            Contact("Ron", "Weasley", "2", "Wisley7@gmail.com", "+441132854563", R.mipmap.emoticon1_foreground),
            Contact("Hermione", "Granger", "3", "CrumNotBad@gmail.com", "+441142864543", R.mipmap.emoticon1_foreground),
            Contact("Draco", "Malfoy", "4", "MyFatherWillHearAboutThis@gmail.com", "+441138554261", R.mipmap.emoticon1_foreground),
            Contact("Severus", "Snape", "5", "Always@gmail.com", "+441132454444", R.mipmap.emoticon1_foreground),
            Contact("Sirius", "Black", "6", "likeDogs@gmail.com", "+441136854536", R.mipmap.emoticon1_foreground),
            Contact("Cho", "Chang", "7", "MissCedric@gmail.com", "+441134584569", R.mipmap.emoticon1_foreground),
            Contact("Minerva ", "McGonagall", "8", "Kitty@gmail.com", "+441147654573", R.mipmap.emoticon1_foreground),
        )
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.listFrame, ListFragment.newInstance("first parameter","second parameter"))
            .addToBackStack(null)
            .commit()
    }
}

class Contact(var name: String, var lastName: String, var suffix: String, var email: String, var phone: String, var photo: Int)