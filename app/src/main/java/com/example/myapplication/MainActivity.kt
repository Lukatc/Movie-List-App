package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    // ფილმების IMDB კოდების სია
    private val movieIds = listOf(
        "tt0499549",
        "tt1087260",
        "tt0120338",
        "tt0468569",
        "tt1375666",
        "tt0371746",
        "tt3581920",
        "tt26743210",
        "tt4154796",
        "tt0388629",
        "tt1211837"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val movies = mutableListOf<Movie>()

        for (id in movieIds) {
            RetrofitClient.instance.getMovieById(id).enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    response.body()?.let {
                        // ვამოწმებთ რომ ფილმი არ იყოს ეპიზოდი (მაგ. "Episode #1.70")
                        if (!it.Title.contains("Episode #")) {
                            movies.add(it)
                            recyclerView.adapter = MovieAdapter(this@MainActivity, movies)
                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.e("API_ERROR", t.message ?: "Unknown error")
                }
            })
        }
    }
}
