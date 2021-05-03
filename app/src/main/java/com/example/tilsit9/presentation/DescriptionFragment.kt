package com.example.tilsit9.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.tilsit9.R


class DescriptionFragment : Fragment() {

    private val args: DescriptionFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.description_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imView: ImageView = view.findViewById(R.id.iv_description)
        val tvTitleDescr: TextView = view.findViewById(R.id.tv_title_description)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)

        val imageTitle = args.MODELARGS
        imView.load(imageTitle)
        tvDescription.text=args.DescriptionARGS
        tvTitleDescr.text=args.TITLEARGS

    }
}