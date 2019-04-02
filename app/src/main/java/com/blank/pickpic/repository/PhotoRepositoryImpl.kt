package com.blank.pickpic.repository

import com.blank.pickpic.data.Photo
import com.blank.pickpic.exception.Failure
import com.blank.pickpic.functional.Either
import com.blank.pickpic.services.UpsplashService
import timber.log.Timber


class PhotoRepositoryImpl(
    private val upsplashService: UpsplashService
) : PhotoRepository {

    override fun getPhotos(page: Int): Either<List<Photo>, Failure> = try {
        val response = upsplashService.getPhotos(page).execute()
        when (response.isSuccessful) {
            true -> Either.Left(response.body() as List<Photo>)
            false -> Either.Right(Failure.ServerError)
        }
    } catch (e: Throwable) {
        Timber.e(e)
        Either.Right(Failure.NetworkConnection)
    }

}