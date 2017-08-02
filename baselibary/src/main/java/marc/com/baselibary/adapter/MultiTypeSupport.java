package marc.com.baselibary.adapter;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 10:22
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface MultiTypeSupport<T> {

	public int getLayoutId(T item,int position);
}
