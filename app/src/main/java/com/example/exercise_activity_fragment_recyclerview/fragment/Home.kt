package com.example.exercise_activity_fragment_recyclerview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.adapter.AdapterListIndex
import com.example.exercise_activity_fragment_recyclerview.databinding.FragmentHomeBinding
import com.example.exercise_activity_fragment_recyclerview.model.Index
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentWithMain
import kotlin.random.Random

class Home() : Fragment() {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(
            LayoutInflater.from(
                requireContext()
            )
        )
    }
    private lateinit var indexs: MutableList<Index>
    private lateinit var adapterIndexs: AdapterListIndex

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        indexs = mutableListOf()
        addData()
        adapterIndexs = AdapterListIndex(indexs)
        binding.lvIndex.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterIndexs
        }
        ItemTouchHelper(itemTouchHelper).attachToRecyclerView(binding.lvIndex)

        binding.btnBell.setOnClickListener {  }
        binding.btnLoadMoreIndex.setOnClickListener {
            addData()
            adapterIndexs.notifyDataSetChanged()
        }
    }

    private fun addData() {
        indexs.add(
            Index(
                randomId(),
                "DOWN JONES",
                "NYSE",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
        indexs.add(
            Index(
                randomId(),
                "FTSE 100",
                "LONDON",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
        indexs.add(
            Index(
                randomId(),
                "IBEX 35",
                "MADRID",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
        indexs.add(
            Index(
                randomId(),
                "DAX",
                "XETRA",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
        indexs.add(
            Index(
                randomId(),
                "DOWN JONES",
                "NYSE",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
        indexs.add(
            Index(
                randomId(),
                "FTSE 100",
                "LONDON",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
        indexs.add(
            Index(
                randomId(),
                "IBEX 35",
                "MADRID",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
        indexs.add(
            Index(
                randomId(),
                "DAX",
                "XETRA",
                "10:44:45",
                20047.50,
                "+203 (+1,04%)"
            )
        )
    }

    var itemTouchHelper = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            indexs.removeAt(viewHolder.adapterPosition)
            adapterIndexs.notifyDataSetChanged()
        }

    }

    private fun randomId(): Int {
        return Random.nextInt(0, 99999999)
    }
}