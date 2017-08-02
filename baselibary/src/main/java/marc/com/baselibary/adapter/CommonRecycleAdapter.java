package marc.com.baselibary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import marc.com.baselibary.listner.OnItemClickListner;
import marc.com.baselibary.listner.OnItemLongPressListner;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 10:14
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public abstract class CommonRecycleAdapter<T> extends RecyclerView.Adapter<ViewHolder>
							/*implements MultiTypeSupport*/{

	private MultiTypeSupport mMultiTypeSupport;

	private List<T> mDatas;

	private int mLayoutId;

	private Context mContext;

	private LayoutInflater mInflater;

	public CommonRecycleAdapter(Context context, List<T> datas, int layoutId) {
		this.mDatas = datas;
		this.mLayoutId = layoutId;
		this.mContext = context;
		mInflater = LayoutInflater.from(this.mContext);
	}

	public CommonRecycleAdapter(Context mContext, List<T> mDatas, MultiTypeSupport mMultiTypeSupport) {
		this.mMultiTypeSupport = mMultiTypeSupport;
		this.mDatas = mDatas;
		this.mContext = mContext;
		this.mLayoutId = -1;
	}

	@Override
	public int getItemViewType(int position) {
		if(mMultiTypeSupport!=null){
			return mMultiTypeSupport.getLayoutId(mDatas.get(position),position);
		}
		return super.getItemViewType(position);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if(mMultiTypeSupport != null){
			mLayoutId = viewType;
		}
		View itemView = mInflater.inflate(mLayoutId,parent,false);
		ViewHolder holder = new ViewHolder(itemView);
		return holder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {

		if(mClickListner!=null){
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					mClickListner.onClick((RecyclerView) v.getParent(),position);
				}
			});
		}
		if(mLongPressListenr != null){
			holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					return mLongPressListenr.onLongPress((RecyclerView) v.getParent(),position);
				}
			});
		}

		convert(holder,mDatas.get(position));
	}

	@Override
	public int getItemCount() {
		return mDatas.size();
	}

	public abstract void convert(ViewHolder holder,T item);

	public OnItemClickListner mClickListner;
	public OnItemLongPressListner mLongPressListenr;

	public void setmClickListner(OnItemClickListner mClickListner) {
		this.mClickListner = mClickListner;
	}

	public void setmLongPressListenr(OnItemLongPressListner mLongPressListenr) {
		this.mLongPressListenr = mLongPressListenr;
	}
}
