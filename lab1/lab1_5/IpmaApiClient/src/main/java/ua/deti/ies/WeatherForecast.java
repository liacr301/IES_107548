package ua.deti.ies;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.deti.ies.IpmaCityForecast2;
import ua.deti.ies.IpmaService2;
public class WeatherForecast {

        private static int city;

        public void setCity(int city) {this.city = city;}

        public int getCity() {
        return city;
    }

        public static void main(String[] args) {

            // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.ipma.pt/open-data/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // create a typed interface to use the remote API (a client)
            IpmaService2 service = retrofit.create(IpmaService2.class);
            // prepare the call to remote endpoint
            Call<IpmaCityForecast2> callSync = service.getForecastForACity(city);

            try {
                Response<IpmaCityForecast2> apiResponse = callSync.execute();
                IpmaCityForecast2 forecast = apiResponse.body();

                if (forecast != null) {
                    var firstDay = forecast.getData().listIterator().next();

                    System.out.printf("max temp for %s is %4.1f %n",
                            firstDay.getForecastDate(),
                            Double.parseDouble(firstDay.getTMax()));
                } else {
                    System.out.println("No results for this request!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}
