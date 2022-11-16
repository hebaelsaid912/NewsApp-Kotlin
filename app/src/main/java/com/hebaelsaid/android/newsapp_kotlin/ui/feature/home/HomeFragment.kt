package com.hebaelsaid.android.newsapp_kotlin.ui.feature.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hebaelsaid.android.newsapp_kotlin.databinding.FragmentHomeBinding
import com.hebaelsaid.android.newsapp_kotlin.domain.uimodel.NewsFeedUiModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "HomeFragment"
@AndroidEntryPoint
class HomeFragment : Fragment() , NewsListAdapter.NewsListViewHolder.OnItemClickListener{
    private lateinit var binding:FragmentHomeBinding
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentHomeBinding.inflate(inflater, container, false)
       // viewModel = HomeViewModel(NewsDatabase.getDatabase(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderNewsData()
    }

    private fun renderNewsData() {
        lifecycleScope.launchWhenStarted {

            viewModel._newsFeedDBState.collect{ newsItemState ->
                when(newsItemState){
                    is HomeViewModel.NewsFeedState.Success -> {
                        Log.d(TAG, "renderNewsData: Success")
                        Log.d(TAG, "renderNewsData: newsList size: ${newsItemState.newsFeedList.size}")
                        binding.mainEmptyView.visibility = View.GONE
                        setUpNewsList(newsItemState.newsFeedList)
                    }
                    is HomeViewModel.NewsFeedState.Loading -> {
                        Log.d(TAG, "renderNewsData: Loading")
                        binding.mainEmptyView.visibility = View.VISIBLE
                    }
                    is HomeViewModel.NewsFeedState.Error -> {
                        Log.d(TAG, "renderNewsData: Error: ${newsItemState.message}")
                        binding.mainEmptyView.visibility = View.VISIBLE
                    }
                    is HomeViewModel.NewsFeedState.Idle -> {
                        Log.d(TAG, "renderNewsData: Idle")
                        binding.mainEmptyView.visibility = View.VISIBLE
                        viewModel.getNewsFeedData()
                    }
                }

            }
        }
    }

    private fun setUpNewsList(newsFeedList: ArrayList<NewsFeedUiModel>) {
        val adapter = NewsListAdapter(this)
        adapter.submitList(newsFeedList)
        binding.homeNewsRv.adapter = adapter
        binding.homeNewsRv.visibility = View.VISIBLE
    }

    override fun onItemClick(newsFeedUiModel: NewsFeedUiModel?) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment())
    }

}