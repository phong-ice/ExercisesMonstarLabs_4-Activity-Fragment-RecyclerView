package com.example.exercise_activity_fragment_recyclerview.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.databinding.FragmentNewsBinding
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentNews
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentWithMain
import kotlinx.android.synthetic.main.activity_main2.*

class News() : Fragment(), CommunicationFragmentNews {

    private val binding: FragmentNewsBinding by lazy {
        FragmentNewsBinding.inflate(
            LayoutInflater.from(
                requireContext()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addFragment(NewArticle(this), "NewArticle")
        Log.i(
            "testFragment",
            "${parentFragmentManager.backStackEntryCount} : ${childFragmentManager.backStackEntryCount}"
        )

        binding.btnBack.setOnClickListener {
            if (childFragmentManager.backStackEntryCount == 1) {
                parentFragmentManager.popBackStack()
                var index = parentFragmentManager.backStackEntryCount - 2
                var backEntry = parentFragmentManager.getBackStackEntryAt(index);
                var tag = backEntry.name;
                var fragment = parentFragmentManager.findFragmentByTag(tag);

                when (fragment) {
                    parentFragmentManager.findFragmentByTag("Home") -> {
                        activity?.nav_bottom_main?.getMenu()?.findItem(R.id.home_fragment)
                            ?.setChecked(true);
                    }
                    parentFragmentManager.findFragmentByTag("Coin") -> {
                        activity?.nav_bottom_main?.getMenu()?.findItem(R.id.coin_fragment)
                            ?.setChecked(true);
                    }
                    parentFragmentManager.findFragmentByTag("Costomer") -> {
                        activity?.nav_bottom_main?.getMenu()?.findItem(R.id.costomer_fragment)
                            ?.setChecked(true);
                    }
                }
            } else {
                childFragmentManager.popBackStack()
                binding.tvTitleScreen.text = "News"
            }
        }
    }

    private fun addFragment(fr: Fragment, name: String) {
        var transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.host_fragment_news, fr, name)
        transaction.addToBackStack(name)
        transaction.commit()
    }

    override fun itemOnClick(newArticle: NewsArticle, fr: Fragment, name: String) {
        var bundle = Bundle()
        bundle.putString("titleNews", newArticle.title)
        bundle.putString("dateNews", newArticle.date)
        bundle.putString("contentNews", newArticle.content)
        fr.arguments = bundle
        var transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.host_fragment_news, fr, name)
        transaction.addToBackStack(name)
        transaction.commit()

        binding.tvTitleScreen.text = newArticle.title
    }


}