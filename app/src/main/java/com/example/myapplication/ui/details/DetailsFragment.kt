package com.example.myapplication.ui.details
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.core.view.isGone
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.example.myapplication.ui.main.MainActivity
import com.example.myapplication.ui.main.MainViewModel
class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override fun setBinding(): FragmentDetailsBinding =
        FragmentDetailsBinding.inflate(layoutInflater)

    private lateinit var viewModel: MainViewModel
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainViewModel

        setupUI(view)
//        setupObserver()
    }

    private fun setupUI(view: View) {
        val news = args.news
//        view.findNavController();
        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            news.url?.let { loadUrl(it) }

        }


        binding.fab.setOnClickListener {
            viewModel.saveNews(news)
            Snackbar.make(view, "News article added to favorites.", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupObserver() {
        viewModel.getFavoriteNews().observe(viewLifecycleOwner) { news ->
            binding.fab.isGone = news.any { it.title == args.news.title }
        }
    }
}