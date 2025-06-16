package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// ინტერფეისი რომელიც განსაზღვრავს როგორ მოხდება API-სთან დაკავშირება
interface MovieApi {

    // @GET ნიშნავს რომ ვიყენებთ GET ტიპის HTTP მოთხოვნას, მისამართზე "/"
    @GET("/")
    fun getMovieById(
        // @Query("i") ნიშნავს რომ მოთხოვნაში იგზავნება ID (მაგ. tt7286456)
        @Query("i") id: String,

        // API გასაღები — საჭიროა OMDb API-სთან წვდომისთვის
        @Query("apikey") apiKey: String = "f474fc72"
    ): Call<Movie> // Call<Movie> ნიშნავს რომ ვიღებთ ერთ კონკრეტულ ფილმს
}
