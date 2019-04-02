package com.blank.pickpic.usecases

import com.blank.pickpic.data.Photo
import com.blank.pickpic.exception.Failure
import com.blank.pickpic.functional.Either
import com.blank.pickpic.repository.PhotoRepository


class GetPhotos(
    private val photoRepository: PhotoRepository
) : UseCase<List<Photo>, Unit>() {

    override suspend fun run(params: Unit): Either<List<Photo>, Failure> =
        photoRepository.getPhotos(1)

}