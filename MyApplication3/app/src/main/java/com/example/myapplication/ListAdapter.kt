package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// ListAdapter არის ადაპტერი, რომელიც გამოიყენება ListView-ში მონაცემების გამოსატანად
class ListAdapter(
    private val context: Context, // კონტექსტი საჭიროებია layout-ის გასაფუშად
    private val images: Array<Int>, // სურათების მასივი
    private val names: Array<String> // სახელების (ფილმების) მასივი
) : BaseAdapter() {

    // აბრუნებს ელემენტების რაოდენობას
    override fun getCount(): Int = names.size

    // აბრუნებს კონკრეტულ ელემენტს სიის მიხედვით
    override fun getItem(position: Int): Any = names[position]

    // აბრუნებს უნიკალურ ID-ს ელემენტის პოზიციის მიხედვით
    override fun getItemId(position: Int): Long = position.toLong()

    // მთავარი მეთოდი, რომელიც ქმნის ან ახლებურად იყენებს View-ს თითოეული ელემენტისთვის
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            // თუ View ჯერ არ არსებობს, ვქმნით მას LayoutInflater-ის საშუალებით
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

            // ვქმნით ViewHolder ობიექტს, რომელიც ინახავს View-ებს უკეთესი მუშაობისთვის
            viewHolder = ViewHolder()
            viewHolder.name = view.findViewById(R.id.name)
            viewHolder.image = view.findViewById(R.id.img)

            // ვამაგრებთ ViewHolder-ს View-ზე
            view.tag = viewHolder
        } else {
            // თუ View უკვე არსებობს, ვიყენებთ მას თავიდან შექმნის ნაცვლად
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        // ვავსებთ ტექსტი და სურათი შესაბამისი მონაცემებით
        viewHolder.name?.text = names[position]
        viewHolder.image?.setImageResource(images[position])

        return view
    }

    // ViewHolder კლასის მიზანია ელემენტების კეშირება - უკეთესი წარმადობისთვის
    private class ViewHolder {
        var name: TextView? = null
        var image: ImageView? = null
    }
}
