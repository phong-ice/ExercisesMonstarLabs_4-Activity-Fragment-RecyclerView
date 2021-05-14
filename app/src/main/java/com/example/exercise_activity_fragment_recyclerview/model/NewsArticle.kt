package com.example.exercise_activity_fragment_recyclerview.model

data class NewsArticle(
    var img: Int,
    var date: String,
    var sale: String,
    var title: String,
    var description: String,
    var content:String,
    var viewType:Int
) {
    companion object{
        val ITEM_NEW_ARTICLE_HEADER = 1
        val ITEM_NEW_ARTICLE_HOT = 2
        val ITEM_NEW_ARTICLE_NORMAL = 3
    }
}