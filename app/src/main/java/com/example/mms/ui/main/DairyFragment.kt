package com.example.mms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mms.adapter.DailyAdapteur
import com.example.mms.databinding.FragmentDairyBinding
import com.example.mms.model.DairyNote

class DairyFragment: Fragment() {

    private var _binding: FragmentDairyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var textAdapter: DailyAdapteur

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        this._binding = FragmentDairyBinding.inflate(inflater, container, false)
        val root: View = this.binding.root

        val noteRV: RecyclerView = this.binding.notesMyNotes

        val items = mutableListOf<DairyNote>()
        items.add(DairyNote("test"))

        // set adapter
        textAdapter = DailyAdapteur(requireContext(), items)
        noteRV.layoutManager = LinearLayoutManager(requireContext())
        noteRV.adapter = textAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}