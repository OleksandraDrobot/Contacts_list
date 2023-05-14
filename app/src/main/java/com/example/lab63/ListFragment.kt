package com.example.lab63

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab63.adapter.Adapter
import com.example.lab63.contacts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.security.auth.callback.Callback

class ListFragment : Fragment(), Callback {

    private lateinit var listRecyclerView: RecyclerView
    private lateinit var addContactButton: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecyclerView = view.findViewById(R.id.ListRecyclerView)
        addContactButton = view.findViewById(R.id.addContactButton)
        listRecyclerView.adapter = Adapter(contacts, requireContext(), this)
        listRecyclerView.layoutManager = LinearLayoutManager(activity)
        addContactButton.setOnClickListener{onAddSelected()}
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ListFragment()
    }
    fun onItemSelected(i: Int) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.detailsFrame, DetailsFragment.newInstance(i))
            ?.addToBackStack(null)
            ?.commit()
    }
    fun onEditSelected(i: Int) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.detailsFrame, EditFragment.newInstance(i))
            ?.addToBackStack(null)
            ?.commit()
    }
    fun onAddSelected() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.detailsFrame, AddFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }


}
