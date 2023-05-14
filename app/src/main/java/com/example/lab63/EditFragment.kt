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

class EditFragment : Fragment() {
    private var index: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(ARG_PARAMETER1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etName = view.findViewById<EditText>(R.id.etEditName)
        val etLastName = view.findViewById<EditText>(R.id.etEditLastName)
        val etSuffix = view.findViewById<EditText>(R.id.etEditSuffix)
        val etPhone = view.findViewById<EditText>(R.id.etEditPhone)
        val etEmail = view.findViewById<EditText>(R.id.etEditEmail)
        val ivPhoto = view.findViewById<ImageView>(R.id.ivEditPhoto)
        val btSave = view.findViewById<Button>(R.id.btSave)
        etName.setText(contacts[index!!].name)
        etLastName.setText(contacts[index!!].lastName)
        etSuffix.setText(contacts[index!!].suffix)
        etPhone.setText(contacts[index!!].phone)
        etEmail.setText(contacts[index!!].email)
        ivPhoto.setImageResource(contacts[index!!].photo)

        btSave.setOnClickListener{
            contacts[index!!].name = etName.text.toString()
            contacts[index!!].lastName = etLastName.text.toString()
            contacts[index!!].suffix = etSuffix.text.toString()
            contacts[index!!].phone = etPhone.text.toString()
            contacts[index!!].email = etEmail.text.toString()
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.listFrame, ListFragment.newInstance("first parameter","second parameter"))
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    companion object {
        fun newInstance(index: Int) =
            EditFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAMETER1, index)
                }
            }
    }
}
