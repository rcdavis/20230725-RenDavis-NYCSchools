package rcdavis.nycschools.util;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import rcdavis.nycschools.BuildConfig;
import rcdavis.nycschools.school.SchoolAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static SchoolAPI createSchoolApi() {
        return createApi(SchoolAPI.class, BuildConfig.SCHOOL_API_URL);
    }

    public static <T> T createApi(final Class<T> tClass, final String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build()
                .create(tClass);
    }
}
