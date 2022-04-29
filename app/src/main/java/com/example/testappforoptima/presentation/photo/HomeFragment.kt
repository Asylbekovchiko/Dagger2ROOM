package com.example.testappforoptima.presentation.photo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.domain.models.PhotosResponseItem
import com.example.testappforoptima.R
import com.example.testappforoptima.app.App
import com.example.testappforoptima.base.BaseFragment
import com.example.testappforoptima.databinding.FragmentHomeBinding
import com.example.testappforoptima.internetAvailability
import com.example.testappforoptima.presentation.MainAdapter
import com.example.testappforoptima.presentation.MainViewModel
import com.example.testappforoptima.presentation.MainViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel
    lateinit var adapter: MainAdapter

    override fun init() {

        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)
        adapter = MainAdapter {
            val bundle = Bundle()
            bundle.putString("author", it.author)
            bundle.putString("photo", it.download_url)
            findNavController().navigate(R.id.action_homeFragment_to_blankFragment, bundle)
        }

        lifecycleScope.launch {
            var list = ArrayList<PhotosResponseItem>()
            if (internetAvailability()) {
                vm.getData()
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    list = vm.getDataDB()
                    lifecycleScope.launch {
                        adapter.setListSMS(list)
                    }
                }
            }
        }

        vm._ld.observe(viewLifecycleOwner) {
            adapter.setListSMS(it)
            CoroutineScope(Dispatchers.IO).launch {

                val listDB = vm.getDataDB()

                for (i in it) {

                    if (!listDB.contains(i)) {
                        vm.insertDB(i)
                    }
                }
                Log.e("list", "${listDB.size}")
            }

        }

        binding.rvPhotos.adapter = adapter
    }



    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
