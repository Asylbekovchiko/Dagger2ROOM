package com.example.testappforoptima.presentation.photo

import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.testappforoptima.R
import com.example.testappforoptima.base.BaseFragment
import com.example.testappforoptima.databinding.FragmentBlankBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BlankFragment : BaseFragment<FragmentBlankBinding>(FragmentBlankBinding::inflate) {

    override fun init() {
        super.init()
        binding.tvAuthor.text = arguments?.getString("author")
        Glide.with(binding.ivPhoto).load(arguments?.getString("photo")).into(binding.ivPhoto)

        binding.ivArrowBack.setOnClickListener {
            findNavController().run {
                popBackStack()
            }
        }

        val botomNav =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        botomNav.visibility = View.GONE
    }

}
