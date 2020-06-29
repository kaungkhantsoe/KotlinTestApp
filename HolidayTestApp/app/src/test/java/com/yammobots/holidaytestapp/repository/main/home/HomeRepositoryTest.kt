package com.yammobots.holidaytestapp.repository.main.home

import android.accounts.NetworkErrorException
import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.model.base.Resource
import com.yammobots.holidaytestapp.network.HomeApi
import com.yammobots.holidaytestapp.repository.main.home.HomeRepository.Companion.ALBUM_ID_CANNOT_BE_ZERO_ERROR
import com.yammobots.holidaytestapp.util.AppConstants.CONNECTION_OR_SERVER_ERROR
import com.yammobots.holidaytestapp.util.TestUtil
import com.yammobots.holidaytestapp.util.TestUtil.EMPTY_LIST
import com.yammobots.holidaytestapp.util.TestUtil.PHOTO_MODEL_LIST
import io.reactivex.Flowable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import java.lang.RuntimeException
import kotlin.Exception

/**
 * Created by kaungkhantsoe on 19/06/2020.
 **/
class HomeRepositoryTest {

    // system under test
    private lateinit var homeRepository: HomeRepository

    @Mock
    private lateinit var homeApi: HomeApi

    @BeforeEach
    private fun initBeforeEach() {
        MockitoAnnotations.initMocks(this)
        homeRepository = HomeRepository(homeApi)
    }

    @Test
    internal fun getPhotos_returnSuccess() {
        // Arrange
        val list = ArrayList(PHOTO_MODEL_LIST)
        val returnedData = Flowable.just(list)
        `when`(homeApi.getPhotos(anyInt()))
            .thenReturn(returnedData)

        // Act
        val returnedValue = homeRepository.getPhotos(1, EMPTY_LIST).blockingFirst()

        // Assert
        assertEquals(Resource.success(list), returnedValue)
    }

    @Test
    internal fun getPhotosWithPaging_returnSuccess() {
        // Arrange
        val list = ArrayList(PHOTO_MODEL_LIST)
        val returnedData = Flowable.just(list)
        `when`(homeApi.getPhotos(anyInt()))
            .thenReturn(returnedData)

        // Act
        val returnedValue = homeRepository.getPhotos(1, list).blockingFirst()

        // Assert
        assertEquals(Resource.success(list), returnedValue)
    }

    @Test
    @Throws(Exception::class)
    internal fun getPhotos_returnServerError() {
        `when`(homeApi.getPhotos(anyInt()))
            .thenReturn(Flowable.error(Throwable(CONNECTION_OR_SERVER_ERROR)))

        // Act
        val returnedValue = homeRepository.getPhotos(1, EMPTY_LIST).blockingFirst()

        // Assert
        assertEquals(Resource.error(CONNECTION_OR_SERVER_ERROR, ArrayList<PhotoModel>()), returnedValue)
    }

    @Test
    @Throws(Exception::class)
    internal fun getPhotosWithAlbumIdZero_throwAlbumIdCannotBeZeroException() {

        // Arrange
        val list: ArrayList<PhotoModel> = ArrayList()
        val returnedData = Flowable.just(list)
        `when`(homeApi.getPhotos(anyInt())).thenReturn(returnedData)

        // Act

        // Assert
        val exception = assertThrows(Exception::class.java, Executable {
            homeRepository.getPhotos(-1, EMPTY_LIST)
        })

        assertEquals(ALBUM_ID_CANNOT_BE_ZERO_ERROR, exception.message)
    }

    @Test
    internal fun getPhotos_returnNull() {

        // Arrange
        val list = ArrayList<PhotoModel>()
        val returnedData = Flowable.just(list)
        `when`(homeApi.getPhotos(anyInt())).thenReturn(null)

        // Act
        val returnedValue = homeRepository.getPhotos(1, EMPTY_LIST).blockingFirst()

        // Assert
        assertEquals(Resource.error(CONNECTION_OR_SERVER_ERROR, list), returnedValue)
    }

    @Test
    internal fun getPhotos_returnError() {

        // Arrange
        val list = ArrayList<PhotoModel>()
        val model = TestUtil.TEST_PHOTO_MODEL_1
        model.id = -1

        list.add(model)

        val returnedData = Flowable.just(list)
        `when`(homeApi.getPhotos(anyInt())).thenReturn(returnedData)

        // Act
        val returnedValue = homeRepository.getPhotos(1, EMPTY_LIST).blockingFirst()

        // Assert
        assertEquals(Resource.error(CONNECTION_OR_SERVER_ERROR, ArrayList<PhotoModel>()), returnedValue)
    }

}


