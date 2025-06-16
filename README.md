# Movie App

An Android app that shows a list of popular movies. You can see movie details like story, rating, and pictures.

## Screenshots

### Movie List Screen
<img src="screenshots/Screenshot%202025-06-16%20152136.png" alt="Movie List" width="300">

### Movie Detail Screen
<img src="screenshots/Screenshot%202025-06-16%20152149.png" alt="Movie Detail" width="300">

## Features

- **Movie List**: See many movies in a simple list
- **Movie Details**: Click on a movie to see more information
- **Internet Data**: Gets fresh movie information from the internet
- **Easy to Use**: Smooth scrolling and fast loading
- **Movie Pictures**: Shows movie posters and images

## 🛠 Tech Stack

- **Kotlin** - Programming language
- **Retrofit** - Gets data from internet
- **RecyclerView** - Shows lists fast
- **OMDb API** (https://www.omdbapi.com/) - Gets movie data like titles, pictures, ratings, and stories
- **Glide** - Loads and saves pictures

**IMPORTANT:**
This app needs a working OMDb API key to get movie data. The app comes with a demo API key, but you should get your own free key from OMDb [here](https://www.omdbapi.com/apikey.aspx). Free API keys can make **1000 requests per day**.

## Movie List

The app shows these popular movies:
- Avatar (2009)
- Inception (2010) 
- Titanic (1997)
- The Dark Knight (2008)
- And 7 more movies

All movie information comes from OMDb API (a free movie database).

## 📂 How to Run

1. **Download the code**
2. **Open in Android Studio**
3. **Get your own API key from OMDb and replace the demo key in RetrofitClient.kt file**
4. **Wait for setup to finish**
5. **Press Run button**

## 📄 Terms of Use

- This app gets movie information from OMDb API, so you must follow OMDb's [rules](https://www.omdbapi.com/terms)
- The app uses **internet data** to get fresh movie information

## How the App Works

### Main Parts

**MainActivity**
- The first screen you see when you open the app
- Shows the list of movies
- Gets movie data from the internet

**Movie**
- Holds information about one movie
- Has movie name, year, rating, story, and picture

**MovieAdapter**
- Shows movies in the list
- Makes the app run fast
- Handles when you click on a movie

**MovieDetailActivity**
- Shows all details about one movie
- Gets movie information from the main screen
- Shows big picture, name, rating, and story

**Internet Connection**
- **RetrofitClient**: Connects to the internet
- **MovieApi**: Gets movie data from OMDb website
- Changes internet data into app data

## File Organization

```
Main folder/
├── MainActivity.kt          # Main screen
├── MovieDetailActivity.kt   # Detail screen
├── Movie.kt                 # Movie information
├── MovieAdapter.kt          # List manager
├── MovieApi.kt              # Internet connection
├── RetrofitClient.kt        # Internet setup
└── ListAdapter.kt           # Old file (not used)
```

## Why the App is Fast

- **Smart Lists**: Reuses parts to save memory
- **Picture Storage**: Saves pictures so they load faster
- **Good Internet Use**: Only loads data when needed
- **Memory Care**: Doesn't waste phone memory

## What You Need

- **Android Phone**: Any modern Android phone
- **Internet**: Needed to get movie data and pictures
