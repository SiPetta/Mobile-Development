package com.dicoding.sipetta.view
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.sipetta.R
import com.dicoding.sipetta.data.pref.DummyDataProvider

class DetailPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val tvLabel: TextView = findViewById(R.id.tv_item_label)
        val tvTextSim: TextView = findViewById(R.id.tv_item_textsim)
        val tvSeverity: TextView = findViewById(R.id.tv_item_severity)
        val ivReply: ImageView = findViewById(R.id.iv_item_fav)
        val ivFav: ImageView = findViewById(R.id.iv_item_reply)
        val ivAvatar: ImageView = findViewById(R.id.iv_item_photo)

        val postItem = DummyDataProvider.getPostById(1)

        tvName.text = postItem?.name
        tvDescription.text = postItem?.description
        tvLabel.text = postItem?.label
        tvTextSim.text = postItem?.textSim
        tvSeverity.text = postItem?.severity
        ivReply.setImageResource(R.drawable.ic_reply)
        ivFav.setImageResource(R.drawable.ic_fav)
        ivAvatar.setImageResource(R.drawable.avatar)
    }
}
