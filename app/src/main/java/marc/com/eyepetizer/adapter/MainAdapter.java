package marc.com.eyepetizer.adapter;

import android.content.Context;

import java.util.List;

import marc.com.eyepetizer.R;
import marc.com.eyepetizer.bean.MainBean;
import marc.com.multrecycleadapter.CommonRecycleAdapter;
import marc.com.multrecycleadapter.ViewHolder;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 10:08
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class MainAdapter extends CommonRecycleAdapter{

	private int mLayoutId;

	public MainAdapter(Context context, List datas, int layoutId) {
		super(context, datas, layoutId);
		this.mLayoutId = layoutId;
	}

	@Override
	public void convert(ViewHolder holder, Object item) {
		MainBean.ItemListBean bean = (MainBean.ItemListBean) item;
		holder.setText(R.id.description,bean.getData().getDescription());
	}

	@Override
	public int getLayoutId(Object item, int position) {
		return mLayoutId;
	}
}
