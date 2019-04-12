package com.blank.pickpic.usecases

import com.blank.pickpic.exception.Failure
import com.blank.pickpic.functional.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class UseCase<out T, in P> where T : Any {

    operator fun invoke(
        params: P,
        onResult: (Either<T, Failure>) -> Unit = {}
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                onResult(run(params))
            }
        }
    }

    abstract suspend fun run(params: P): Either<T, Failure>

    class None
}