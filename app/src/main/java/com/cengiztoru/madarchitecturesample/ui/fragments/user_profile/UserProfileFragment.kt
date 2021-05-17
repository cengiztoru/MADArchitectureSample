package com.cengiztoru.madarchitecturesample.ui.fragments.user_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cengiztoru.madarchitecturesample.databinding.FragmentUserProfileBinding

private const val USER_ID = "user_id"

class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding
    private var userId: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvUserId.text = userId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserProfileBinding.inflate(layoutInflater)
        userId = arguments?.getString(USER_ID)
        return binding.root
    }

    companion object {
        fun newInstance(userId: String) = UserProfileFragment().apply {
            val args = Bundle()
            args.putString(USER_ID, userId)
            arguments = args
        }
    }
}