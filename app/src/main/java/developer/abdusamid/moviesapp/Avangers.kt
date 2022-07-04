package developer.abdusamid.moviesapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import developer.abdusamid.moviesapp.Cache.MySharedPreference
import kotlinx.android.synthetic.main.activity_avangers.*

class Avangers : AppCompatActivity() {
    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avangers)
        val position = intent.getIntExtra("position", 0)
        MySharedPreference.init(this)
        val array = MySharedPreference.objectString
        val name = array[position].name
        val author = array[position].author
        val description = array[position].description
        val date = array[position].date
        txt_name.text = "${txt_name.text} $name"
        txt_about.text = "${txt_about.text} $description"
        txt_authors.text = "${txt_authors.text} $author"
        txt_data.text = "${txt_data.text} $date"
        btn_close.setOnClickListener {
            finish()
        }
    }
}