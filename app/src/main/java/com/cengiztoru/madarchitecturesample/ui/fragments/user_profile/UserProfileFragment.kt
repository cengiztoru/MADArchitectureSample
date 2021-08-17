package com.cengiztoru.madarchitecturesample.ui.fragments.user_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cengiztoru.madarchitecturesample.databinding.FragmentUserProfileBinding
import com.cengiztoru.madarchitecturesample.viewmodels.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val SEARCH_QUERY = "search_query"

@AndroidEntryPoint
class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding
    private var searchQuery: String? = null

    private val viewModel: UserProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserProfileBinding.inflate(layoutInflater)
        searchQuery = arguments?.getString(SEARCH_QUERY)
        binding.data = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    companion object {
        fun newInstance(userId: String) = UserProfileFragment().apply {
            val args = Bundle()
            args.putString(SEARCH_QUERY, userId)
            arguments = args
        }
    }
}