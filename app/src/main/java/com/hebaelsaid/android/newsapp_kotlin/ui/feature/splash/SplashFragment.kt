package com.hebaelsaid.android.newsapp_kotlin.ui.feature.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hebaelsaid.android.newsapp_kotlin.databinding.FragmentSplashBinding
import com.hebaelsaid.android.newsapp_kotlin.domain.data.local.database.NewsDatabase
import com.hebaelsaid.android.newsapp_kotlin.domain.data.local.entities.KotlinNewsFeed
import com.hebaelsaid.android.newsapp_kotlin.utils.CommonFunction.isOnline
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "SplashFragment"
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private val viewModel by lazy { 
        ViewModelProvider(this)[SplashViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(isOnline(requireContext())) {
            renderNewsData()
        }
        Handler(Looper.getMainLooper()).postDelayed({
             findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }, 10000)
    }
    private fun renderNewsData() {
        lifecycleScope.launchWhenStarted {
            viewModel._newsFeedApiState.collect { newsItemState ->
                when (newsItemState) {
                    is SplashViewModel.NewsFeedState.Success -> {
                        Log.d(TAG, "renderNewsData: Success")
                        Log.d(
                            TAG,
                            "renderNewsData: newsList size: ${newsItemState.newsFeedList.size}"
                        )
                        insertRecipeDataIntoRoomDB(newsItemState.newsFeedList)
                    }
                    is SplashViewModel.NewsFeedState.Loading -> {
                        Log.d(TAG, "renderNewsData: Loading")
                    }
                    is SplashViewModel.NewsFeedState.Error -> {
                        Log.d(TAG, "renderNewsData: Error: ${newsItemState.message}")
                    }
                    is SplashViewModel.NewsFeedState.Idle -> {
                        Log.d(TAG, "renderNewsData: Idle")
                        viewModel.getNewsFeedData()
                    }
                }

            }
        }
    }

        private fun insertRecipeDataIntoRoomDB(newsItems: ArrayList<KotlinNewsFeed>) {
            lifecycleScope.launch(Dispatchers.Default) {
                this.let {
                    clearDatabase()
                    for (element in newsItems) {
                        NewsDatabase.getDatabase(requireContext())
                            .newsDao().insertKotlinNews(element)
                    }
                }
            }
        }
        private fun clearDatabase() {
            lifecycleScope.launch(Dispatchers.Default) {
                this.let {
                    NewsDatabase.getDatabase(requireContext()).newsDao().clearKotlinNewsDatabase()
                }
            }
        }
    }
