package charlieandroidblog.esy.es.retrofit2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static final String EXT_URL = "todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public IEndPointAPI makeRetrofitCall(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) //la base del rest service
                .addConverterFactory(GsonConverterFactory.create())  //deserializa el json..
                .build();

        return retrofit.create(IEndPointAPI.class);
    }

    private void tryRetrofit() {

        IEndPointAPI endPointApi =  makeRetrofitCall();
        Call<List<CustomObject>> myObjects = endPointApi.getCustomObject();

        myObjects.enqueue(new Callback<List<CustomObject>>() {

            @Override
            public void onResponse(Call<List<CustomObject>> call, Response<List<CustomObject>> response) {
                Log.d("zzz", "onResponse:  we successfully used Retrofit");
            }

            @Override
            public void onFailure(Call<List<CustomObject>> call, Throwable t) {
                Log.d("zzz", "onResponse:  we screw up when we used Retrofit");
            }
        });

        Log.d("zzz", "tryRetrofit: echo..");

    }

    public void btnRetrofitClicked(View view) {
        tryRetrofit();
    }
}
