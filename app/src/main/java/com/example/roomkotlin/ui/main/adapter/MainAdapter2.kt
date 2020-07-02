package com.example.roomkotlin.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.request.LoadRequest
import com.example.roomkotlin.R
import com.example.roomkotlin.data.model.Product
import kotlinx.android.synthetic.main.item_layout2.view.*

class MainAdapter2(private val products: ArrayList<Product>) : RecyclerView.Adapter<MainAdapter2.DataViewHolder>() {

    interface OnItemClick {
        fun onClick(itemName: String?,quantity:String?)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(products: Product) {
            val imageLoader = Coil.imageLoader(itemView.imageViewAvatarr.context)
            val request = LoadRequest.Builder(itemView.context)
                .data(products.image)
                .target(itemView.imageViewAvatarr)
                .build()
            imageLoader.execute(request)
        }


        val minButton = itemView.findViewById<Button>(R.id.minButton)
        val plusButton = itemView.findViewById<Button>(R.id.plusButton)
        val quantityTextView = itemView.findViewById<TextView>(R.id.quantityTextView)
        val productName = itemView.findViewById<TextView>(R.id.productName)
        val priceTextView = itemView.findViewById<TextView>(R.id.priceTextView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout2, parent,
                false
            )

    )

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(products[position])
        holder.productName.setText(products[position].name)
        holder.priceTextView.setText(products[position].price)


        var count: Int = 0
        var value: String = ""
        holder.plusButton.setOnClickListener {
            count++
            value = Integer.toString(count);
            holder.quantityTextView.setText(value)

        }
        holder.minButton.setOnClickListener {
            if (value.equals(0)) {
                count = 0
                value = Integer.toString(count);
                holder.quantityTextView.setText(value)

            } else {
                count--
                value = Integer.toString(count);
                holder.quantityTextView.setText(value)

            }

        }

    }


    fun addData(list: ArrayList<Product>) {
        products.addAll(list)
    }

}

//
//
//holder.mPlus.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Log.e("mListener", "mListener :Clicked");
//        if (mListener != null) {
//            mListener.onPlus(album.getProductId(), holder);
//
//            holder.mAdd.setVisibility(View.GONE);
//            holder.mQtyLayout.setVisibility(View.VISIBLE);
//        }
//    }
//});
//
//VISIBLE


//interface Cart {
//    fun onAdd()
//    fun onPlus(mProductId: String?, holder: CartAdapter.MyViewHolder?)
//    fun onMinus(mProductId: String?, holder: CartAdapter.MyViewHolder?)
//}

