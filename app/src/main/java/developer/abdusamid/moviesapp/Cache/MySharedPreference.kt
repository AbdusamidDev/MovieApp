package developer.abdusamid.moviesapp.Cache

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import developer.abdusamid.moviesapp.Models.Cinema

object MySharedPreference {
    private const val NAME = "KeshXotiraga"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var objectString: ArrayList<Cinema>
        get() = gsonStringToArray(sharedPreferences.getString("object", "[]"))
        set(value) = sharedPreferences.edit() {
            it.putString("object", arrayToGsonString(value))
        }

    private fun arrayToGsonString(arrayList: ArrayList<Cinema>): String {
        return Gson().toJson(arrayList)
    }

    private fun gsonStringToArray(gsonString: String?): java.util.ArrayList<Cinema> {
        val typeToken = object : TypeToken<ArrayList<Cinema>>() {}.type
        return Gson().fromJson(gsonString, typeToken)
    }
}