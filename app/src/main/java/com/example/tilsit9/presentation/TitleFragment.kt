package com.example.tilsit9.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tilsit9.R
import com.example.tilsit9.domain.Model
import org.koin.androidx.viewmodel.ext.android.viewModel

class TitleFragment : Fragment() {

    private val myViewModel: TitleViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.title_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listImage: RecyclerView? = view.findViewById(R.id.recyclerView)
        val myAdapter = MyAdapter(onClickTitleCard)
        listImage?.adapter = myAdapter

        myViewModel.loadDataList.observe(viewLifecycleOwner, Observer { dataSource ->

            when (dataSource) {

                is Status.Loading -> {
                    Toast.makeText(
                        requireContext(),
                        "все идет по плану,ждите..",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                is Status.Success -> {
                    dataSource.let { list ->
                        myAdapter.submitList(list.data)
                        myAdapter.notifyDataSetChanged()

                    }
                }
                is Status.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        "error:${dataSource}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        })
    }

    private val onClickTitleCard = object : OnClickTitleCard {
        override fun onClick(model: Model) {
            val action =
                TitleFragmentDirections.actionTitleFragmentToDescriptionFragment(model.image, model.description,model.title)
            Navigation.findNavController(view!!).navigate(action)

        }
    }
}

interface OnClickTitleCard {
    fun onClick(model: Model)
}
