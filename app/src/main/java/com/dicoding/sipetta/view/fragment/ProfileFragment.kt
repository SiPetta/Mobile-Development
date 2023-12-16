package com.dicoding.sipetta.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.dicoding.sipetta.R
import com.dicoding.sipetta.view.login.LoginActivity
import com.dicoding.sipetta.view.welcome.WelcomeActivity
import de.hdodenhof.circleimageview.CircleImageView

class ProfileFragment : Fragment() {

    private lateinit var avatarImageView: CircleImageView
    private lateinit var tvUsername: TextView
    private lateinit var logoutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        avatarImageView = view.findViewById(R.id.avatarImageView)
        tvUsername = view.findViewById(R.id.tv_username)
        logoutButton = view.findViewById(R.id.logoutButton)

        avatarImageView.setImageResource(R.drawable.avatar)

        tvUsername.text = "Aqyun"

        logoutButton.setOnClickListener {
            startActivity(Intent(context, WelcomeActivity::class.java))
            requireActivity().finish()
        }

        return view
    }
}
