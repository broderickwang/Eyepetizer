package marc.com.eyepetizer.net;

import io.reactivex.Observable;
import marc.com.eyepetizer.bean.MainBean;
import retrofit2.http.GET;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 11:05
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface Api {

	@GET("api/v4/tabs/selected")
	Observable<MainBean> getMain();
}
