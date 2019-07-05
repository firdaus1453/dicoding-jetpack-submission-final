package com.anangkur.madesubmission1.feature.main.tv

import com.anangkur.madesubmission1.data.model.Response
import com.anangkur.madesubmission1.data.model.TvParent
import com.anangkur.madesubmission1.utils.Const
import com.google.gson.Gson

class TvPresenter(private val view: TvView) {
    fun createDataPopular(){
        val result = Gson().fromJson(Const.jsonNowPlayingMovies, Response::class.java).results
        val listTvParent = ArrayList<TvParent>()
        for (i in 0 until 10){
            listTvParent.add(TvParent(Const.titlePopular, result))
        }
        view.onPopularDataReady(listTvParent)
    }
}