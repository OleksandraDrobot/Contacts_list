package com.example.lab63

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_PARAMETER1 = "parameter1"

class DetailsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvLastName = view.findViewById<TextView>(R.id.tvLastName)
        val tvSuffix = view.findViewById<TextView>(R.id.tvSuffix)
        val tvPhone = view.findViewById<TextView>(R.id.tvPhone)
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        val ivPhoto = view.findViewById<ImageView>(R.id.ivPhoto)
        val editButton = view.findViewById<ImageView>(R.id.ivEdit)
        tvName.text = contacts[index!!].name
        tvLastName.text = contacts[index!!].lastName
        tvSuffix.text = contacts[index!!].suffix
        tvPhone.text = contacts[index!!].phone
        tvEmail.text = contacts[index!!].email
        ivPhoto.setImageResource(contacts[index!!].photo)

        editButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.detailsFrame, EditFragment.newInstance(index!!))
                ?.addToBackStack(null)
                ?.commit()
        }

        val delete = view.findViewById<ImageView>(R.id.ivDelete)
        delete.setOnClickListener{
            val alert = view.findViewById<LinearLayout>(R.id.llDeletingConfirm)
            alert.visibility = View.VISIBLE

            val y = view.findViewById<Button>(R.id.btDeleteYes)
            y.setOnClickListener {
                contacts.removeAt(index!!)
                activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.listFrame, ListFragment.newInstance("first parameter","second parameter"))
                    ?.addToBackStack(null)
                    ?.commit()
            }

            val n = view.findViewById<Button>(R.id.btDeleteNo)
            n.setOnClickListener {
                alert.visibility = View.INVISIBLE
            }
        }
    }

    companion object {
        fun newInstance(index: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAMETER1, index)
                }
            }
    }
}
