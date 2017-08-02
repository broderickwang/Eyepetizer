package marc.com.eyepetizer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import marc.com.eyepetizer.R;
import marc.com.eyepetizer.adapter.MainAdapter;
import marc.com.eyepetizer.bean.MainBean;
import marc.com.eyepetizer.util.ApiService;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 11:19
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class MainFragment extends Fragment {
	@BindView(R.id.main_list)
	RecyclerView mMainList;
	Unbinder unbinder;
	private MainAdapter mAdapter;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.main_fragment, container, false);
		unbinder = ButterKnife.bind(this, v);
		mMainList.setLayoutManager(new LinearLayoutManager(getContext()));
		mAdapter = new MainAdapter(getContext(),null,R.layout.main_fragment_item);
		mMainList.setAdapter(mAdapter);

		getData();
		return v;
	}

	public static MainFragment newInstance() {

		Bundle args = new Bundle();

		MainFragment fragment = new MainFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	private void getData(){
		ApiService.apiService().getMain()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(new Consumer<MainBean>() {
					@Override
					public void accept(@NonNull MainBean mainBean) throws Exception {
						mAdapter.setmDatas(mainBean.getItemList());
						mAdapter.notifyDataSetChanged();
					}
				});

	}
}
