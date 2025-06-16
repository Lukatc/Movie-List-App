package com.example.myapplication

// მონაცემთა კლასი, რომელიც წარმოადგენს ერთი ფილმის მონაცემებს
data class Movie(
    val Title: String,        // ფილმის სახელი
    val Year: String,         // გამოშვების წელი
    val imdbRating: String,   // IMDb რეიტინგი
    val Plot: String,         // ფილმის აღწერა
    val Poster: String        // ფილმის პოსტერის URL (ონლაინ მისამართი)
)
