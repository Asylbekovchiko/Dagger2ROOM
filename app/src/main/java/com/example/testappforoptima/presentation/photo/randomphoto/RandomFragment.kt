package com.example.testappforoptima.presentation.photo.randomphoto

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.domain.models.PhotosResponseItem
import com.example.testappforoptima.base.BaseFragment
import com.example.testappforoptima.databinding.FragmentRandomBinding
import com.example.testappforoptima.presentation.MainViewModel
import com.example.testappforoptima.presentation.MainViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

class RandomFragment : BaseFragment<FragmentRandomBinding>(FragmentRandomBinding::inflate) {
    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel

    private var list : ArrayList<PhotosResponseItem>? = null
    private var photo : String? = null

    override fun init() {
        super.init()
        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            list = vm.getDataDB()
            if(list?.isNotEmpty() == true){

                val randomElement = list!!.random()

                binding.tvAuthor.text = randomElement.author
                lifecycleScope.launch {
                    Glide.with(binding.tvAuthor).load(randomElement.download_url).into(binding.ivPhoto)

                }
            }

        }





    }
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
