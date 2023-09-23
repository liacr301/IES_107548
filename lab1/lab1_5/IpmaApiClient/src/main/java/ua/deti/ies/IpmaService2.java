package ua.deti.ies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface IpmaService2 {
    @GET("forecast/meteorology/cities/daily/{city_id}.json")
    Call<IpmaCityForecast2> getForecastForACity(@Path("city_id") int cityId);
}
