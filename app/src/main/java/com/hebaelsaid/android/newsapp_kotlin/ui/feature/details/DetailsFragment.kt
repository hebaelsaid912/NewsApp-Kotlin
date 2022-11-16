package com.hebaelsaid.android.newsapp_kotlin.ui.feature.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hebaelsaid.android.newsapp_kotlin.databinding.FragmentDetailsBinding
import com.hebaelsaid.android.newsapp_kotlin.domain.uimodel.NewsFeedUiModel

private const val TAG = "DetailsFragment"

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var newsModel: NewsFeedUiModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsModel = arguments?.getParcelable<NewsFeedUiModel>("news_desc")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = newsModel
        binding.newsDetailsBackImg.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}