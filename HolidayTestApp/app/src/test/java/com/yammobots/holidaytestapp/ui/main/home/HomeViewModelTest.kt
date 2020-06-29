package com.yammobots.holidaytestapp.ui.main.home

import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.model.base.Resource
import com.yammobots.holidaytestapp.repository.main.home.HomeRepository
import com.yammobots.holidaytestapp.repository.main.home.HomeRepository.Companion.ALBUM_ID_CANNOT_BE_ZERO_ERROR
import com.yammobots.holidaytestapp.util.InstantExecutorExtension
import com.yammobots.holidaytestapp.util.TestUtil
import com.yammobots.holidaytestapp.util.TestUtil.EMPTY_LIST
import com.yammobots.holidaytestapp.util.getOrAwaitValue
import io.reactivex.Flowable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.function.Executable
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.lang.Exception

/**
 * Created by kaungkhantsoe on 22/06/2020.
 **/

@ExtendWith(InstantExecutorExtension::class)
class HomeViewModelTest {

    // System under test
    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var homeRepository: HomeRepository

    @BeforeEach
    internal fun initBeforeEach() {
        MockitoAnnotations.initMocks(this)
        homeViewModel = HomeViewModel(homeRepository)
    }

    @Test
    internal fun getPhoto_returnData() {

        // Arrange
        val listResource = Resource.success(ArrayList(TestUtil.PHOTO_MODEL_LIST))
        val returnedData = Flowable.just(listResource)

        `when`(homeRepository.getPhotos(anyInt(), anyCollection<PhotoModel>() as ArrayList<PhotoModel>)).thenReturn(returnedData)

        homeViewModel.albumId = 1
        // Act
        val returnedValue = homeViewModel.observePhotos().getOrAwaitValue()

        // Assert
        verify(homeRepository).getPhotos(anyInt(), anyCollection<PhotoModel>() as ArrayList<PhotoModel>)
        assertEquals(listResource,returnedValue)
    }


    @Test
    internal fun getPhotoWithAlbumIdZero_returnError() {

        // Arrange
        val listResource = Resource.error(ALBUM_ID_CANNOT_BE_ZERO_ERROR,ArrayList<PhotoModel>())
        val returnedData = Flowable.just(listResource)

        `when`(homeRepository.getPhotos(anyInt(), anyCollection<PhotoModel>() as ArrayList<PhotoModel>)).thenReturn(returnedData)

        homeViewModel.albumId = 0

        // Act
        val returnedValue = homeViewModel.observePhotos().getOrAwaitValue()

        // Assert
        verify(homeRepository).getPhotos(anyInt(), anyCollection<PhotoModel>() as ArrayList<PhotoModel>)
        assertEquals(listResource,returnedValue)
    }


}