package com.setiadi.myapplicationbab5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


class FragmentA : Fragment(), View.OnClickListener {

    private lateinit var communicator: Communicator
    lateinit var sendBtn: Button
    lateinit var etInputNama: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_a, container, false)
        sendBtn = view.findViewById(R.id.sendBtn)
        etInputNama = view.findViewById(R.id.etInputNama)

        communicator = activity as Communicator


        sendBtn.setOnClickListener {
            val intent = Intent(context, MainActivity2::class.java)
            startActivity(intent)
                      }
        return view
    }
    override fun onClick(p0: View?) {
        communicator.passDataCom(etInputNama.text.toString())
    }
}

