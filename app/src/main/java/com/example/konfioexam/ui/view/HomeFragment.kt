package com.example.konfioexam.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.konfioexam.R
import com.example.konfioexam.data.adapter.DogAdapter
import com.example.konfioexam.data.adapter.IDogListener
import com.example.konfioexam.data.model.DogResponse
import com.example.konfioexam.databinding.FragmentHomeBinding
import com.example.konfioexam.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment(), IDogListener {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = FragmentHomeBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onCreateViewModel()
        viewModel.listDogsViewModel.observe(viewLifecycleOwner, {

            this.binding.rvListDogs.layoutManager = LinearLayoutManager(this.requireContext())
            this.binding.rvListDogs.adapter = DogAdapter(it, this)
        })

    }

    override fun clickCardView(entity: DogResponse) {
        val bundle = bundleOf("entity" to entity)
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}