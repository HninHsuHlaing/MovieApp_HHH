package com.padcx.movieapp_hhh.data.models

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.padcx.movieapp_hhh.MovieApi
import com.padcx.movieapp_hhh.data.vos.*
import com.padcx.movieapp_hhh.network.responses.GetDiscoverResponse
import com.padcx.movieapp_hhh.persistent.dbs.*
import com.padcx.movieapp_hhh.util.PARAM_API_KEY
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieModelImpl : BaseModel(),MovieModel{
//    override fun getPopularMovies(
//        onSuccess: (List<ResultVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//
//        var resultlist = mMovieApi.getPopularMoveList(PARAM_API_KEY)
//            .map { it.result }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//               Log.d("tag",it.toString())
//            })
//
//    }

  @SuppressLint("CheckResult")
  private   fun getAllPopularMovieFromApi_andSaveToDB(){
            mMovieApi.getPopularMoveList(PARAM_API_KEY)
                .map {
                    it.result
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("Tour",it.toString())
                    mPopularMovieDB.PopularMovieDaos().insertAllPopularMovie(it)
                })
    }

    @SuppressLint("CheckResult")
    private fun getAllActorListFromApi_andSaveToDb(){
        mMovieApi.loadActorList(PARAM_API_KEY)
            .map {
                it.result }
            .subscribeOn((Schedulers.io()))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mActorMovieDb.ActorDaos().insertAllActorList(it)
            })
    }


    @SuppressLint("CheckResult")
    private fun getAllShowCaseFromApi_andSaveDb(){
        mMovieApi.loadNowPlayForShowCase(PARAM_API_KEY)
            .map {
                it.result
            }
            .subscribeOn((Schedulers.io()))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mShowCaseDb.ShowCaseDaos().insertAllActorList(it)
            })

    }

    @SuppressLint("CheckResult")
    private fun getAllGenerListFromApi_abdSaveToDb(){

        mMovieApi.loadGenerList(PARAM_API_KEY)
            .map {
                it.geners
            }
            .subscribeOn((Schedulers.io()))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mGenerDb.GenerDaos().insertAllActorList(it)
            }){
                Log.e("error",it.localizedMessage)
            }

    }
    override fun getShowCaseList(onFailure: (String) -> Unit):  LiveData<List<ShowCaseVO>> {
        getAllShowCaseFromApi_andSaveDb()
        return mShowCaseDb.ShowCaseDaos().getAllActorList()
    }

    override fun getGenerList(onFailure: (String) -> Unit): LiveData<List<GenerVO>> {
        getAllGenerListFromApi_abdSaveToDb()
        return mGenerDb.GenerDaos().getAllActorList()
    }



    @SuppressLint("CheckResult")
    override fun getAllDiscoverListFromApiAndSaveToDatabase(
        genericname: String,
        onSuccess: (List<DiscoverVO>)-> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getDiscoverList(PARAM_API_KEY,genericname)
            .map {
                it.results
                   //     as ((GetDiscoverResponse) -> List<DiscoverVO?>)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it != null) {
                    onSuccess(it
                            as List<DiscoverVO>
                    )
                    mDiscoverDb.DiscoverDaos().insertDiscoverData(it)
                }
            })
          //  .map { it.results?.toList() ?: listOf() })
    }

    override fun getMovieDetailById(
        smovieId: Int
    ): LiveData<MovieDetailsVO> {
            return mPopularMovieDB.PopularMovieDaos().getAllMovieDetail(movie_id = smovieId)
    }

    @SuppressLint("CheckResult")
    override fun getMovieDetailFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        Log.e("save method=","ff");
        mMovieApi.getMovieDetailById(movieId, PARAM_API_KEY)
            .map {
                it?.let { it } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it?.let { it1 -> mPopularMovieDB.PopularMovieDaos().insertMovieDetailData(it1) }
            },{

            })
    }

    @SuppressLint("CheckResult")
    override fun getAllCrewAndCastFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        mMovieApi.getMovieDetailByActorsAndCreator(movieId, PARAM_API_KEY)
            .map{it}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mPopularMovieDB.PopularMovieDaos().insertCastCrewData(it)
            },{
               // onError(it.localizedMessage ?: )
            })
    }

    override fun getAllCastAndCrewList(
        movieId: Int,
        onError: (String) -> Unit
    ): LiveData<CastCrewVO> {
        return mPopularMovieDB.PopularMovieDaos()
            .getAllCastAndCrewList(movie_id = movieId)
    }

    @SuppressLint("CheckResult")
    override fun getVideoIdByMovieId(
        movieId: Int,
        onSuccess: (List<VideoVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getVideoIdByMovieId(movieId, PARAM_API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it.let {
                    onSuccess(it as List<VideoVO>)
                }
            },{
              //  onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllTopRatedMovieList(onError: (String) -> Unit): LiveData<List<TopRateMovieVO>> {
        return mPopularMovieDB.PopularMovieDaos()
            .getAllTopRatedMovies()
    }

    @SuppressLint("CheckResult")
    override fun getAllTopRatedMovieListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getTopRatedMovies(PARAM_API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mPopularMovieDB.PopularMovieDaos().insertAllTopRatedMovieData(it)
            },{
             //   onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllDiscoverList(
        genericname: String,
        onError: (String) -> Unit
    ): LiveData<List<DiscoverVO>> {
       return mDiscoverDb.DiscoverDaos().getAllDiscoverList()
    }

    override fun getAllDiscoverList(genericname: Int): Observable<MovieDetailsVO> {
      return mMovieApi.getMovieDetailById(genericname, PARAM_API_KEY)
//           .map { it }
//           .subscribeOn(Schedulers.io())
//           .observeOn(AndroidSchedulers.mainThread())
//           .subscribe({
//
//           })
    }

//    fun getAllMovie() : LiveData<List<PopularMovieVO>>{
//        return mDB
//    }


    override fun getactorList(onFailure: (String) -> Unit): LiveData<List<ActorVO>> {
        getAllActorListFromApi_andSaveToDb()
        return mActorMovieDb.ActorDaos().getAllActorList()
    }




    override fun getPopularMovies(onFailure: (String) -> Unit): LiveData<List<ResultVO>> {
        getAllPopularMovieFromApi_andSaveToDB()
       return mPopularMovieDB.PopularMovieDaos().getAllPopularMovie()

    }



    fun initDatabase(context: Context){
        mPopularMovieDB = Populardb.getDBInstance(context)
        mActorMovieDb = ActorDb.getDBInstance(context)
        mShowCaseDb = ShowCaseDb.getDBInstance(context)
        mGenerDb = GenerDb.getDBInstance(context)
        mDiscoverDb = DiscoverDb.getDBInstance(context)
    }

//    override fun getPopularMovies(
//        onSuccess: (List<ResultVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ){
//        mDataAgent.getPopularMovie(PARAM_API_KEY,onSuccess = {
//            onSuccess.invoke(it)
//        },onfailure = {
//            onFailure.invoke(it)})
//    }


}
