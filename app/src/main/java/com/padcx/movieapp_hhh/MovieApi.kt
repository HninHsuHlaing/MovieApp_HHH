package com.padcx.movieapp_hhh

import com.padcx.movieapp_hhh.data.vos.CastCrewVO
import com.padcx.movieapp_hhh.data.vos.MovieDetailsVO
import com.padcx.movieapp_hhh.network.responses.*
import com.padcx.movieapp_hhh.util.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET(GET_Movie)
    fun getPopularMoveList(@Query("api_key") apiKey : String) : Observable<GetmoviePopularResponse>

    @GET(GET_Actor)
    fun loadActorList(@Query("api_key")apiKey : String)  : Observable<GetActorResponse>

    @GET(GET_NOW_PLAY)
    fun loadNowPlayForShowCase(@Query("api_key") apiKey: String) : Observable<GetShowCaseResponse>

    @GET(GET_GENER_LIST)
    fun loadGenerList(@Query("api_key") apiKey: String) : Observable<GetGenerListResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetailById(@Path("movie_id") movie_id: Int, @Query("api_key") apiKey: String): Observable<MovieDetailsVO>

//    @GET("/person/{person_id}")
//    fun getPersonDetail(@Path("person_id") person_id : Int, @Query("api_key") api_key : String ) : Observable<>
    @GET(GET_MOVIE_DISCOVER)
    fun getDiscoverList(
        @Query("api_key") apiKey: String, @Query("with_genres") with_genres: String): Observable<GetDiscoverResponse>


    @GET("movie/{movie_id}/credits")
    fun getMovieDetailByActorsAndCreator(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Observable<CastCrewVO>

    @GET("movie/{movie_id}/videos")
    fun getVideoIdByMovieId(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Observable<GetVideoResponse>
}