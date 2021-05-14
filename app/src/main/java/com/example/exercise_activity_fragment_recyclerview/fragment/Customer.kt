package com.example.exercise_activity_fragment_recyclerview.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.adapter.AdapterListMenuCustomer
import com.example.exercise_activity_fragment_recyclerview.adapter.AdapterListMenuCustomer.Companion.HEADER
import com.example.exercise_activity_fragment_recyclerview.adapter.AdapterListMenuCustomer.Companion.TYPE_1
import com.example.exercise_activity_fragment_recyclerview.adapter.AdapterListMenuCustomer.Companion.TYPE_2
import com.example.exercise_activity_fragment_recyclerview.databinding.FragmentCostomerBinding
import com.example.exercise_activity_fragment_recyclerview.model.ItemMenuCustomer
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentWithMain
import kotlinx.android.synthetic.main.activity_main2.*

class Customer() : Fragment() {

    private val binding: FragmentCostomerBinding by lazy {
        FragmentCostomerBinding.inflate(
            layoutInflater
        )
    }
    private lateinit var adapterListMenu: AdapterListMenuCustomer
    private lateinit var itemMenus: MutableList<ItemMenuCustomer>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        itemMenus = mutableListOf()
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_alarm, "Alerts", TYPE_1))
        itemMenus.add(
            ItemMenuCustomer(
                R.mipmap.icons_8_left_and_right_arrows,
                "Predictions",
                TYPE_1
            )
        )
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_pin, "Saved elements", TYPE_1))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_no_entry, "Remove Ads", TYPE_1))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_profit_2, "Tools", HEADER))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_profit_2, "Select Stocks", TYPE_2))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_swap, "Currency Exchange", TYPE_2))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_video_call, "Webinar", TYPE_2))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_rent, "Best Broker", TYPE_2))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_profit_2, "Markets", HEADER))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_profit_2, "Select Stocks", TYPE_2))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_swap, "Currency Exchange", TYPE_2))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_video_call, "Webinar", TYPE_2))
        itemMenus.add(ItemMenuCustomer(R.mipmap.icons_8_rent, "Best Broker", TYPE_2))
        adapterListMenu = AdapterListMenuCustomer(itemMenus)

        binding.lvMenu.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterListMenu
        }
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
            var index = parentFragmentManager.backStackEntryCount - 2
            var backEntry = parentFragmentManager.getBackStackEntryAt(index);
            var tag = backEntry.name;
            var fragment = parentFragmentManager.findFragmentByTag(tag);
            Log.i("asdasd","${fragment}")
            when(fragment){
                parentFragmentManager.findFragmentByTag("Home") -> {
                    activity?.nav_bottom_main?.getMenu()?.findItem(R.id.home_fragment)?.setChecked(true);
                }
                parentFragmentManager.findFragmentByTag("Coin") -> {
                    activity?.nav_bottom_main?.getMenu()?.findItem(R.id.coin_fragment)?.setChecked(true);
                }
                parentFragmentManager.findFragmentByTag("News") -> {
                    activity?.nav_bottom_main?.getMenu()?.findItem(R.id.news_fragment)?.setChecked(true);
                }
            }
        }
    }

}