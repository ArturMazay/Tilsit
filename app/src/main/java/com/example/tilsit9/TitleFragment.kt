package com.example.tilsit9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class TitleFragment : Fragment() {


    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.title_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listImage: RecyclerView? = view.findViewById(R.id.recyclerView)
        val myAdapter = MyAdapter()
        listImage?.adapter = myAdapter



        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        viewModel.model.observe(viewLifecycleOwner, Observer {
            it?.let {
                myAdapter.data = it
                myAdapter.notifyDataSetChanged()
            }
        })

    }
    companion object {
        fun newInstance(academy: String): TitleFragment {
            val args = Bundle()
            args.putString("android", academy)
            val fragment = TitleFragment()
            fragment.arguments = args
            return fragment
        }
    }



}