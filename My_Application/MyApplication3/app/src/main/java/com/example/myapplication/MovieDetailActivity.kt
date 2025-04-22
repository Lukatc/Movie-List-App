package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

// MovieDetailActivity არის ეკრანი, სადაც ფილმის დეტალები უნდა გამოჩნდეს
class MovieDetailActivity : AppCompatActivity() {

    // onCreate() ფუნქცია ემსახურება ეკრანის გამოჩენას და მონაცემების დამუშავებას
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)  // ინიშნავს ამ ეკრანის layout-ს

        // Intent-იდან იღებს მონაცემებს (პლაკატი, სახელი, აღწერა, რეიტინგი)
        val poster = intent.getStringExtra("poster")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val rating = intent.getStringExtra("rating")

        // ვპოულობთ ყველა საჭირო View-ებს, სადაც ფილმის დეტალები უნდა ვაჩვენოთ
        val img = findViewById<ImageView>(R.id.posterImage)
        val titleView = findViewById<TextView>(R.id.titleText)
        val ratingView = findViewById<TextView>(R.id.ratingText)
        val descView = findViewById<TextView>(R.id.descriptionText)
        val videoImg = findViewById<ImageView>(R.id.playVideo)  // ვიდეოს სურათი

        // Glide-ს ვიყენებთ, რომ დავდოთ პლაკატი და ვიდეო სურათი (Play video image)
        Glide.with(this).load(poster).into(img)  // ასახავს პლაკატს
        Glide.with(this).load(R.drawable.playvideo).into(videoImg)  // ასახავს ვიდეო სურათს

        // დაყენება ტექსტისთვის
        titleView.text = title
        ratingView.text = "IMDb: $rating"  // რეიტინგის ტექსტის განახლება
        descView.text = description  // აღწერის განახლება
    }
}
