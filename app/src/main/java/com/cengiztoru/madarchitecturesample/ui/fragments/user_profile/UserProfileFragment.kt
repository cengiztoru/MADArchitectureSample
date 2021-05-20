package com.cengiztoru.madarchitecturesample.ui.fragments.user_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cengiztoru.madarchitecturesample.databinding.FragmentUserProfileBinding
import com.cengiztoru.madarchitecturesample.viewmodels.UserProfileViewModel

private const val USER_ID = "user_id"

class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding
    private var userId: String? = null

    private val viewModel: UserProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvUserId.text = viewModel.userId
        setObservers()
    }

    private fun setObservers() {
        viewModel.user.observe(viewLifecycleOwner, {
            //updating ui
            binding.tvUserName.text = "user name " + it.name
        })
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