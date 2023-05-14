package com.example.lab63

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val ARG_PARAMETER1 = "parameter1"

class AddFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etName = view.findViewById<EditText>(R.id.etAddName)
        val etLastName = view.findViewById<EditText>(R.id.etAddLastName)
        val etSuffix = view.findViewById<EditText>(R.id.etAddSuffix)
        val etPhone = view.findViewById<EditText>(R.id.etAddPhone)
        val etEmail = view.findViewById<EditText>(R.id.etAddEmail)
        val ivPhoto = view.findViewById<ImageView>(R.id.ivAddPhoto)
        val btAdd = view.findViewById<Button>(R.id.btAdd)

        btAdd.setOnClickListener{
            var newUser = Contact(
                etName.text.toString(),
                etLastName.text.toString(),
                etSuffix.text.toString(),
                etEmail.text.toString(),
                etPhone.text.toString(),
                R.mipmap.emoticon1_foreground
            )

            contacts.add(newUser)
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.listFrame, ListFragment.newInstance("first parameter","second parameter"))
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    companion object {
        fun newInstance() =
            AddFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
