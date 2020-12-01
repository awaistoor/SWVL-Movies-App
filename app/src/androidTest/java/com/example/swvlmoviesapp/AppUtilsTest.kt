package com.example.swvlmoviesapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.swvlmoviesapp.modules.movie_detail_screen.model.Photo
import com.example.swvlmoviesapp.utils.getUrlForGlide
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Unit Test class for AppUtils
 */
@RunWith(AndroidJUnit4::class)
class AppUtilsTest {
    /// a working url for test
    private val testingFlickrUrl =
        "https://farm66.static.flickr.com/65535/32885403967_be14b95a9c.jpg"

    /**
     * Test case for getUrlForGlide if the data is correct
     * which means that the url is concatenated properly
     */
    @Test
    fun validate_getUrlForGlide_success() {
        val photo = Photo(
            farm = 66,
            id = "32885403967",
            isfamily = 0,
            isfriend = 0,
            ispublic = 1,
            owner = "27003603@N00",
            secret = "be14b95a9c",
            server = "65535",
            title = "Gabriel Ynoa"
        )

        val string = getUrlForGlide(photo)
        assertTrue(string == testingFlickrUrl)
    }

    /**
     * Test case for getUrlForGlide if the data is incorrect
     * but the function will still return the concatenated string
     */
    @Test
    fun validate_getUrlForGlide_error() {
        val photo = Photo(
            farm = 49,
            id = "324342342",
            isfamily = 0,
            isfriend = 0,
            ispublic = 1,
            owner = "2345453@N00",
            secret = "be14b95a9c",
            server = "534343",
            title = "Testing title"
        )
        val string = getUrlForGlide(photo)
        assertFalse(string == testingFlickrUrl)
    }

    /**
     * Test case for getUrlForGlide if the data is null
     * which means that function will return empty string
     */
    @Test
    fun validate_getUrlForGlide_return_empty_string() {
        val string = getUrlForGlide(null)
        assertTrue(string.isBlank())
    }
}