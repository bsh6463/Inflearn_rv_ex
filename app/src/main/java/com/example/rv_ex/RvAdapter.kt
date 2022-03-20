package com.example.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//사용할 data를 받음, RecyclerView의 Adapter 상속
class RvAdapter(val items: MutableList<String>) : RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    //ViewHolder객체 생성 및 리턴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    //RecyclerView는 setOnclickListener제공안함. 직접 선언.
    interface ItemClick{
        fun onClick(view:View, position: Int)
    }
    var itemClick: ItemClick? = null


   //ViewHolder가 재활용 될 때 사용하는 메서드
    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {

       //ionCLick 선언
        if (itemClick != null){
            holder.itemView.setOnClickListener{
                v -> itemClick?.onClick(v, position)
            }
        }

       //holder에 item을 bind
        holder.bindItems(items[position])

    }


    //전체 recyclerview 갯수
    override fun getItemCount(): Int {
        return items.size
    }


    //itemView를 들고있는 class, 말 그대로 view를 hold
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        //각 itemView에 data 매핑
        fun bindItems(item: String){
            val rv_text = itemView.findViewById<TextView>(R.id.rv_item)
            rv_text.text = item
        }
    }
}