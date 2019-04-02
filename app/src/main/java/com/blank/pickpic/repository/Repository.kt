package com.blank.pickpic.repository

import com.blank.pickpic.data.Photo
import com.blank.pickpic.exception.Failure
import com.blank.pickpic.functional.Either


abstract interface PhotoRepository {

    fun getPhotos(page: Int): Either<List<Photo>, Failure>

}
