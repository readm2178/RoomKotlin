package com.example.roomkotlin.data.api

import androidx.annotation.NonNull
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    val NEW_URL="https://www.mocky.io/v2/"

    private val httpClient2 = OkHttpClient()

    //new
    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)




    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        )
        .build()
    private val builder2 = Retrofit.Builder()
        .baseUrl(NEW_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())


    fun <S> createService2(serviceClass2: Class<S>): S {
        val retrofit2 = builder2.client(httpClient2).build()
        return retrofit2.create(serviceClass2)
    }

    fun <S> createServiceHeader2(
        serviceClass2: Class<S>, packageName: String,
        SHA1: String
    ): S {

        val okClient = OkHttpClient.Builder()
            .addInterceptor(
                object : Interceptor {
                    @NonNull
                    @Throws(IOException::class)
                    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
                        val original = chain.request()

                        // Request customization: add request headers
                        val requestBuilder = original.newBuilder()
                            .header("X-Android-Package", packageName)
                            .header("X-Android-Cert", SHA1)

//                            .method(original.method(), original.body())

                        val request = requestBuilder.build()
                        return chain.proceed(request)
                    }
                })
            .addInterceptor(loggingInterceptor)
            .build()


        val retrofit2 = builder2.client(okClient).build()
        return retrofit2.create(serviceClass2)

    }
}
