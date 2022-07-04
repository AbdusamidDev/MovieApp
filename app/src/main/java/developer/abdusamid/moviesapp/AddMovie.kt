package developer.abdusamid.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import developer.abdusamid.moviesapp.Cache.MySharedPreference
import developer.abdusamid.moviesapp.Models.Cinema
import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.android.synthetic.main.activity_avangers.*

class AddMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        MySharedPreference.init(this)

        btn_save.setOnClickListener {
            val arrayCinema = MySharedPreference.objectString
            val name = edt_movies_name.text.toString().trim()
            val author = edt_authors_movie.text.toString().trim()
            val description = edt_about_movies.text.toString().trim()
            val date = edt_movie_date.text.toString().trim()
            if (name != "" && author != "" && date != "" && description != "") {
                arrayCinema.add(Cinema(name, author, description, date))
                println(arrayCinema)
                MySharedPreference.objectString = arrayCinema
                finish()
            } else {
                Toast.makeText(this, "Write Something", Toast.LENGTH_SHORT).show()
            }

            fun myAddMovieFunction() {
                arrayCinema.add(
                    Cinema(
                        "Marvel's The Avengers",
                        "Joss Whedon",
                        "In the film, S.H.I.E.L.D. director Nick Fury assembles Iron Man, Captain America, Hulk, Thor, Black Widow and Hawkeye to battle Thor's adoptive brother, Loki, who attempts to subjugate humanity by leading an invasion by the extraterrestrial race known as the Chitauri",
                        "04.05.2012"
                    )
                )

                arrayCinema.add(
                    Cinema(
                        "Spider-Man",
                        "Sam Raimi",
                        "genetically modified spider, a nerdy, shy, and awkward high school student gains spider-like abilities that he eventually must use to fight evil as a superhero after tragedy befalls his family. Based on Marvel Comics' superhero character, this is a story of Peter Parker who is a nerdy high-schooler",
                        "03.04.2002"
                    )
                )

                arrayCinema.add(
                    Cinema(
                        "Spider-Man",
                        "Joss Whedon",
                        "In the film, S.H.I.E.L.D. director Nick Fury assembles Iron Man, Captain America, Hulk, Thor, Black Widow and Hawkeye to battle Thor's adoptive brother, Loki, who attempts to subjugate humanity by leading an invasion by the extraterrestrial race known as the Chitauri.",
                        "03.04.2002"
                    )
                )

                arrayCinema.add(
                    Cinema(
                        "The Social Network",
                        "David Fincher",
                        "'The Social Networt' explores the moment at which Facebook was invented--through the warring perspectives of the super-smart young men who each claimed to be there at its inception.",
                        "01.10.2010"
                    )
                )

                arrayCinema.add(
                    Cinema(
                        "Steve Jobs (Film)",
                        "Daniel Francis Boyle",
                        "A British-American co-production, it was adapted from the 2011 biography by Walter Isaacson and interviews conducted by Sorkin, and covers 14 years (1984–1998) in the life of Apple Inc. co-founder Steve Jobs.",
                        "13.11.2015"
                    )
                )

                arrayCinema.add(
                    Cinema(
                        "The Internships",
                        "Shawn Levy",
                        "Two salesmen whose careers have been torpedoed by the digital age find their way into a coveted internship at Google, where they must compete with a group of young, tech-savvy geniuses for a shot at employment.",
                        "07.07.2013"
                    )
                )
                MySharedPreference.init(this)
            }
        }
    }
}