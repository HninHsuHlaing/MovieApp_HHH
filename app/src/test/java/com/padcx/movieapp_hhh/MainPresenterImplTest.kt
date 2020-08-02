package com.padcx.movieapp_hhh

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.mvp.presenter.MainPresenterImpl
import com.padcx.movieapp_hhh.mvp.view.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var  mView : MainView

    private  lateinit var mModel : MovieModel
    @Before

    fun setUpPresenter(){
  MockKAnnotations.init(this)
        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mModel = MovieModelImpl
        mPresenter = MainPresenterImpl()
        mPresenter.intiPresenter(mView)
        mPresenter.mMovieModel = this.mModel
    }

    @Test
    fun onTapPopularMovieItem_callNavigaterToDetail(){

        val movie = ResultVO()
            movie.id = 1
        mPresenter.onTapMovieITem(movie.id)
        verify {
            mView
                .navigateToactorDetail(movie.id)
        }
    }
    
    @Test
    fun onTapShowCaseItem_callNavigaterToDetail(){
        val showcase = ShowCaseVO()
        showcase.id =  1
        mPresenter.onTapShowCaseItem(showcase.id)
        verify {
            mView.navigateToactorDetail(showcase.id)
        }
    }

}