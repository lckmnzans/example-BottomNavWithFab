package com.simple.bottomnavwithfab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PageFragment : Fragment() {
    private lateinit var tvPageTitle: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvPageTitle = view.findViewById(R.id.tv_page)

        if (arguments != null) {
            val title = arguments?.getString(EXTRA_TITLE).toString()
            tvPageTitle.text = title
        }
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
    }
}