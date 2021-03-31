package com.example.tilsit9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.load


class DescriptionFragment : Fragment() {

    private lateinit var viewModel: DescriptionViewModel
    private val args: DescriptionFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.description_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DescriptionViewModel::class.java)

        val imView: ImageView = view.findViewById(R.id.imageView)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)

        val imageTitle = args.MODELARGS
        imView.load(imageTitle)
        tvDescription.text=args.DescriptionARGS

    }
}