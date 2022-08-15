package com.setiadi.myapplicationbab5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class FragmentA2 : Fragment() {
    private lateinit var communicator: Communicator
    var displayMessage: String? = ""
    lateinit var tvTerimaMessage: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_a2, container, false)

        displayMessage = arguments?.getString(KEY_MESSAGE)
        communicator = activity as Communicator

        tvTerimaMessage = view.findViewById(R.id.tvTerimaMessage)
        tvTerimaMessage.text = displayMessage
        tvTerimaMessage.setOnClickListener {
            communicator.navigateActivity()

        }
        return view
    }
}
