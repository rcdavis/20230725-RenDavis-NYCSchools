package rcdavis.nycschools.util

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import rcdavis.nycschools.BuildConfig
import rcdavis.nycschools.school.SchoolAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    @JvmStatic fun createSchoolApi(): SchoolAPI {
        return createApi(SchoolAPI::class.java, BuildConfig.SCHOOL_API_URL)
    }

    @JvmStatic fun <T> createApi(tClass: Class<T>, baseUrl: String): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(tClass)
    }
}
