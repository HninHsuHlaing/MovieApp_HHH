package com.padcx.movieapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.movieapp_hhh.data.vos.CastCrewVO
import com.padcx.movieapp_hhh.data.vos.MovieDetailsVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.TopRateMovieVO

@Dao
interface PopularMovieDaos {
    @Query("SELECT * FROM PopularMovie_table")
    fun getAllPopularMovie(): LiveData<List<ResultVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovie(country: List<ResultVO>)

    @Query("select * from moviedetail where id=:movie_id")
    fun getAllMovieDetail(movie_id : Int): LiveData<MovieDetailsVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetailData(moviedetail: MovieDetailsVO) : Long

    @Query("select * from castcrew where  sid=:movie_id")
    fun getAllCastAndCrewList(movie_id: Int): LiveData<CastCrewVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCastCrewData(generic: CastCrewVO) :Long

    @Query("select * from topratedmovies")
    fun getAllTopRatedMovies(): LiveData<List<TopRateMovieVO>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTopRatedMovieData(toprates: List<TopRateMovieVO?>)

}