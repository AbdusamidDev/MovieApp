package developer.abdusamid.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import developer.abdusamid.moviesapp.Cache.MySharedPreference
import developer.abdusamid.moviesapp.Models.Cinema
import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.android.synthetic.main.item_view_rv.*

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val position = intent.getIntExtra("position", 0)
        println(position)
        MySharedPreference.init(this)
        val array = MySharedPreference.objectString
        edt_movies_name.setText(array[position].name)
        edt_about_movies.setText(array[position].description)
        edt_authors_movie.setText(array[position].author)
        edt_movie_date.setText(array[position].date)
        btn_edit.setOnClickListener {
            val name = edt_movies_name.text.toString().trim()
            val description = edt_about_movies.text.toString().trim()
            val authors = edt_authors_movie.text.toString().trim()
            val date = edt_movie_date.text.toString().trim()
            array[position] = Cinema(name, authors, description, date)
            MySharedPreference.objectString = array
            Toast.makeText(this, "Edit Movie", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}