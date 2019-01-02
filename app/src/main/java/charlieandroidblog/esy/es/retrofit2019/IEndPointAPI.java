package charlieandroidblog.esy.es.retrofit2019;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static charlieandroidblog.esy.es.retrofit2019.MainActivity.EXT_URL;

public interface IEndPointAPI {

    @GET(EXT_URL) //base url
    Call<List<CustomObject>> getCustomObject();

    //void contacts(Callback<List<User>> cb);

}
