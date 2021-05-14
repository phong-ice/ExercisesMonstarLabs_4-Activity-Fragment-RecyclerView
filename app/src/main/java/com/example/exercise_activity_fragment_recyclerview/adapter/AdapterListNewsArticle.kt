package com.example.exercise_activity_fragment_recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_activity_fragment_recyclerview.databinding.ItemNewsArticleBellBinding
import com.example.exercise_activity_fragment_recyclerview.databinding.ItemNewsArticleBinding
import com.example.exercise_activity_fragment_recyclerview.databinding.ItemNewsHeaderBinding
import com.example.exercise_activity_fragment_recyclerview.fragment.NewArticle
import com.example.exercise_activity_fragment_recyclerview.fragment.NewsArticleDetails
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle.Companion.ITEM_NEW_ARTICLE_HEADER
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle.Companion.ITEM_NEW_ARTICLE_HOT
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle.Companion.ITEM_NEW_ARTICLE_NORMAL
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentNews

class AdapterListNewsArticle(
    var listener: CommunicationFragmentNews,
    var listNewArticle: MutableList<com.example.exercise_activity_fragment_recyclerview.model.NewsArticle>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder_Normal(_binding: ItemNewsArticleBinding) :
        RecyclerView.ViewHolder(_binding.root) {
        var img = _binding.imgItemNewArticle
        var tv_sale = _binding.tvSale
        var tv_title = _binding.tvTitle
        var tv_description = _binding.tvDescription
        var tv_date = _binding.tvDate
    }

    class ViewHolder_Hot(_binding: ItemNewsArticleBellBinding) :
        RecyclerView.ViewHolder(_binding.root) {
        var img = _binding.imgItemNewArticleHot
        var tv_sale = _binding.tvSaleHot
        var tv_title = _binding.tvTitleHot
        var tv_description = _binding.tvDescriptionHot
        var tv_date = _binding.tvDateHot
    }

    class ViewHolder_Header(_binding: ItemNewsHeaderBinding) :
        RecyclerView.ViewHolder(_binding.root) {

        var img = _binding.imgItemNewArticleHeader
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ITEM_NEW_ARTICLE_HEADER -> {
                return ViewHolder_Header(
                    ItemNewsHeaderBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ),
                        parent,
                        false
                    )
                )
            }
            ITEM_NEW_ARTICLE_HOT -> {
                return ViewHolder_Hot(
                    ItemNewsArticleBellBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                return ViewHolder_Normal(
                    ItemNewsArticleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_NEW_ARTICLE_HEADER -> {
                var holder = holder as ViewHolder_Header
                holder.img.setImageResource(listNewArticle[position].img)
                holder.itemView.setOnClickListener {
                    listener.itemOnClick(
                        listNewArticle[position],
                        NewsArticleDetails(),
                        "NewsArticleDetails"
                    )
                }
            }
            ITEM_NEW_ARTICLE_HOT -> {
                var holder = holder as ViewHolder_Hot
                holder.img.setImageResource(listNewArticle[position].img)
                holder.tv_sale.text = listNewArticle[position].sale
                holder.tv_date.text = listNewArticle[position].date
                holder.tv_description.text = listNewArticle[position].description
                holder.tv_title.text = listNewArticle[position].title
                holder.itemView.setOnClickListener {
                    listener.itemOnClick(
                        listNewArticle[position],
                        NewsArticleDetails(),
                        "NewsArticleDetails"
                    )
                }
            }
            else -> {
                var holder = holder as ViewHolder_Normal
                holder.img.setImageResource(listNewArticle[position].img)
                holder.tv_sale.text = listNewArticle[position].sale
                holder.tv_date.text = listNewArticle[position].date
                holder.tv_description.text = listNewArticle[position].description
                holder.tv_title.text = listNewArticle[position].title
                holder.itemView.setOnClickListener {
                    listener.itemOnClick(
                        listNewArticle[position],
                        NewsArticleDetails(),
                        "NewsArticleDetails"
                    )
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listNewArticle.size
    }

    override fun getItemViewType(position: Int): Int {
        var itemNewArticle = listNewArticle[position]
        when (itemNewArticle.viewType) {
            ITEM_NEW_ARTICLE_HEADER -> return ITEM_NEW_ARTICLE_HEADER
            ITEM_NEW_ARTICLE_HOT -> return ITEM_NEW_ARTICLE_HOT
            else -> return ITEM_NEW_ARTICLE_NORMAL
        }
    }

}