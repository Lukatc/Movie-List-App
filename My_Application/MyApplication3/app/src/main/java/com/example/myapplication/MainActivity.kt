package com.example.myapplication


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// MainActivity არის მთავარი Activity, რომელიც გაშვებისას პირველი ჩაიტვირთება
class MainActivity : AppCompatActivity() {

    // RecyclerView ცვლადი სიების გამოსატანად
    private lateinit var recyclerView: RecyclerView

    // ფილმების IMDB კოდების სია - ამ კოდების მიხედვით მოგვაქვს ინფორმაცია ინტერნეტიდან
    private val movieIds = listOf(
        "tt0499549",   // Avatar
        "tt10872600",
        "tt0120338",
        "tt0468569",
        "tt1375666",
        "tt0371746",
        "tt3581920",
        "tt2560140",
        "tt4154796",
        "tt0388629",
        "tt1211837"
    )

    // onCreate ფუნქცია გაეშვება Activity-ს გაშვებისას
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // activity_main.xml layout-ის გამოყენება
        setContentView(R.layout.activity_main)

        // RecyclerView-ის პოვნა layout-დან
        recyclerView = findViewById(R.id.recycler_view)

        // ვუთითებთ რომ ელემენტები იყოს ვერტიკალურად განლაგებული (List-ის სტილში)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ცარიელი სია ფილმებისთვის
        val movies = mutableListOf<Movie>()

        // ყველა IMDB ID-ზე ცალკე მოთხოვნას ვუშვებთ API-სთან
        for (id in movieIds) {
            // Retrofit-ის გამოყენებით ვგზავნით მოთხოვნას
            RetrofitClient.instance.getMovieById(id).enqueue(object : Callback<Movie> {
                // წარმატებული პასუხის მიღებისას
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    response.body()?.let {
                        // ვამატებთ ფილმს სიაში
                        movies.add(it)
                        // ვაახლებთ Adapter-ს, რომელიც RecyclerView-ს აცნობებს სიაში ცვლილებაზე
                        recyclerView.adapter = MovieAdapter(this@MainActivity, movies)
                    }
                }

                // შეცდომის შემთხვევაში ლოგში დაიბეჭდება შეცდომის ტექსტი
                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.e("API_ERROR", t.message ?: "Unknown error")
                }
            })
        }
    }
}
