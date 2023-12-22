package com.dicoding.sipetta.view.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.sipetta.R
import com.dicoding.sipetta.data.pref.PostItem
import com.dicoding.sipetta.view.DetailPostActivity

class PostAdapter(private val postList: List<PostItem>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = postList[position]

        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailPostActivity::class.java).apply {
                putExtra("POST_ID", currentItem.id)
            }
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = postList.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvUsername: TextView = itemView.findViewById(R.id.tv_item_name)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        private val tvLabel: TextView = itemView.findViewById(R.id.tv_item_label)
        private val tvTextSim: TextView = itemView.findViewById(R.id.tv_item_textsim)
        private val tvSeverity: TextView = itemView.findViewById(R.id.tv_item_severity)
        private val ivReply: ImageView = itemView.findViewById(R.id.iv_item_fav)
        private val ivFav: ImageView = itemView.findViewById(R.id.iv_item_reply)
        private val ivAvatar: ImageView = itemView.findViewById(R.id.iv_item_photo)

        fun bind(postItem: PostItem) {
            tvUsername.text = postItem.name
            tvDescription.text = postItem.description
            tvLabel.text = postItem.label
            tvTextSim.text = postItem.textSim
            tvSeverity.text = postItem.severity
            ivReply.setImageResource(R.drawable.ic_reply)
            ivFav.setImageResource(R.drawable.ic_fav)
            ivAvatar.setImageResource(R.drawable.avatar)
        }
    }
}
