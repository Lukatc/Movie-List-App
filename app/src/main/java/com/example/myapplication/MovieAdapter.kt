package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// ადაპტერი RecyclerView-სთვის — გადაეცემა კონტექსტი და ფილმების სია
class MovieAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // ViewHolder — ინახავს ელემენტის კომპონენტებს მეხსიერებაში უკეთესი წარმადობისთვის
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster: ImageView = view.findViewById(R.id.img)     // ფილმის პოსტერის სურათი
        val title: TextView = view.findViewById(R.id.name)       // ფილმის სათაური
        val option: ImageView = view.findViewById(R.id.option)   // "option" ღილაკი
    }

    // ქმნის ViewHolder-ს ანუ ელემენტის ვიზუალურ კომპონენტს list_item ფაილიდან
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MovieViewHolder(view)
    }

    // ამით ხდება კონკრეტული ფილმის ინფორმაციის ბმული კომპონენტზე
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.title.text = movie.Title // სათაურის ტექსტის ჩასმა
        Glide.with(context).load(movie.Poster).into(holder.poster) // Glide-ით სურათის ჩატვირთვა ინტერნეტიდან

        // როცა დააწკაპუნებ option ღილაკს, გაიხსნება MovieDetailActivity და გადაეცემა ინფორმაცია
        holder.option.setOnClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra("title", movie.Title)
            intent.putExtra("rating", movie.imdbRating)
            intent.putExtra("description", movie.Plot)
            intent.putExtra("poster", movie.Poster)
            context.startActivity(intent)
        }
    }

    // აბრუნებს რამდენი ელემენტია მთლიანად სიაში
    override fun getItemCount() = movies.size
}
