package marc.com.eyepetizer.util;

import marc.com.eyepetizer.net.Api;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 11:12
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class ApiService {
	public static Api apiService(){
		Retrofit retrofit = new Retrofit.Builder()
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(CommonValue.BASE_URL)
				.build();
		return retrofit.create(Api.class);
	}
}
