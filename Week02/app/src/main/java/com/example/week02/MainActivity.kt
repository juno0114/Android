package com.example.week02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fcv, fragment_home())
            .commit()

        binding.mainBnv.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.Fragment_home ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fcv, fragment_home())
                        .commit()
                }
                R.id.Fragment_puchase ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fcv, fragment_purchase())
                        .commit()
                }
                R.id.Fragment_wishlist ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fcv, fragment_wishlist())
                        .commit()
                }
                R.id.Fragment_cart ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fcv, fragment_cart())
                        .commit()
                }
                R.id.Fragment_profile ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fcv, fragment_profile())
                        .commit()
                }
            }
            true
        }
    }
}