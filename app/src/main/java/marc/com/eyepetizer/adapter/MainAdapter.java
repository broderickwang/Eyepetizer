package marc.com.eyepetizer.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

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
	private Context mContext;

	public MainAdapter(Context context, List datas, int layoutId) {
		super(context, datas, layoutId);
		this.mLayoutId = layoutId;
		this.mContext = context;
	}

	@Override
	public void convert(ViewHolder holder, Object item) {
		MainBean.ItemListBean bean = (MainBean.ItemListBean) item;
		holder.setText(R.id.title,bean.getData().getTitle());
		String imagePath = "";
		if(bean.getData().getAuthor()!=null){
			imagePath = bean.getData().getAuthor().getIcon();
		}
		holder.setImageByUrl(R.id.pic, new ViewHolder.ImageLoader(imagePath) {
			@Override
			public void displayImage(Context context, ImageView imageView, String imagePath) {
				Glide.with(context).load(imagePath).into(imageView);
			}
		});
	}

	@Override
	public int getLayoutId(Object item, int position) {
		return mLayoutId;
	}
}
