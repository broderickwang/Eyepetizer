package marc.com.baselibary.listner;

import android.support.v7.widget.RecyclerView;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 10:44
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface OnItemClickListner {
	boolean onClick(RecyclerView parent,int position);
}
