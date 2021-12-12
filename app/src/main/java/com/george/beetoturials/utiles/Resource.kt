package com.george.beetoturials.utiles

// that is a class recommended by Google to be used to wrap around our network responses
// and that will be a generic class
// and its very useful to differentiate between successful and error responses
    // and also help us to handel the loading state =>
        // so when we make a response we can show a progress bar while that response is processing
        // and when we get the answer then we can use this class to tell us whether that answer was successful or an error
        // and depending on that we can handel that error or show that successful response


// sealed : it is kind of abstract class
// but we can define which classes are allowed to inherit from that Resource class
data class Resource<T>(
    val success: Status,
    val data: T? = null,
    val message: String? = null
) {

    enum class Status { SUCCESS, ERROR, LOADING, FAILURE }

    companion object {
        fun <T> success(data: T) = Resource(Status.SUCCESS, data, null)
        fun <T> error(message: String, data: T? = null) = Resource(Status.ERROR, data, message)
        fun <T> loading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
        fun <T> failed(message: String, data: T? = null) = Resource(Status.FAILURE, data, message)
    }

}