package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//როგორ მუშაობს Retrofit Client? როდესაც საჭიროა API-დან მონაცემების მიღება (მაგ. ფილმების ინფორმაცია OMDb API-დან), Retrofit Client გაგზავნის HTTP მოთხოვნას.
//მიღებული JSON მონაცემები კონვერტირდება Kotlin ობიექტებად, რათა ისინი მოხერხებულად გავუშვათ სხვა კლასებში.
object RetrofitClient {

    // instance შეიცავს Retrofit-ის ობიექტს, რომელიც ჩვენთვის API-სთან კომუნიკაციას მოაგვარებს
    val instance: MovieApi by lazy {
        // Retrofit-ით ვქმნით ახალი კონფიგურაციის ობიექტს
        Retrofit.Builder()
            // OMDb API-ს ძირითადი URL, სადაც ჩვენს მოთხოვნებს მივაგზავნით
            .baseUrl("https://www.omdbapi.com")
            // GsonConverterFactory არის კონვერტერი, რომელიც JSON-ს ანიჭებს Kotlin-თან შესაბამის ობიექტებს
            .addConverterFactory(GsonConverterFactory.create())

            .build()

            .create(MovieApi::class.java)
    }
}
