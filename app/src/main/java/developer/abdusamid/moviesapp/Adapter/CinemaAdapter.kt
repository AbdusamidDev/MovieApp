package developer.abdusamid.moviesapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdusamid.moviesapp.Models.Cinema
import developer.abdusamid.moviesapp.R
import kotlinx.android.synthetic.main.activity_avangers.view.*
import kotlinx.android.synthetic.main.item_view_rv.view.*

class CinemaAdapter(
    val context: Context,

    var cinemaList: List<Cinema>,

    val myItemClickListener: OnMyItemClickListener

) : RecyclerView.Adapter<CinemaAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(cinema: Cinema, position: Int) {
            println(cinema)

            itemView.txt_name_item_rv.text = cinema.name
            itemView.txt_authors_item_rv.text = cinema.author
            itemView.txt_sana_item_rv.text = cinema.date

            itemView.btn_delete.setOnClickListener {

                myItemClickListener.onMyItemDelete(cinema, position)
            }

            itemView.btn_edit.setOnClickListener {
                myItemClickListener.onMyItemEdit(cinema, position)
            }

            itemView.lin_rv.setOnClickListener {
                myItemClickListener.onMyLinClick(cinema, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_rv, parent, false)
        val myHolder = MyHolder(itemView)
        return myHolder
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(cinemaList[position], position)

    }

    override fun getItemCount(): Int {
        return cinemaList.size
    }

    interface OnMyItemClickListener {
        fun onMyItemDelete(cinema: Cinema, position: Int)
        fun onMyItemEdit(cinema: Cinema, position: Int)
        fun onMyLinClick(cinema: Cinema, position: Int)
        fun onMyItemClckDEdit(cinema: Cinema, position: Int)
        fun onMyItemClckDelete(cinema: Cinema, position: Int)

    }
}