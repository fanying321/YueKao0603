package com.fy.fanying20190603.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.fy.fanying20190603.adapter.Fragment1Adapter;
import com.fy.fanying20190603.R;
import com.fy.fanying20190603.XiangQingActivity;
import com.fy.fanying20190603.bean.Result;
import com.fy.fanying20190603.bean.SouBean;
import com.fy.fanying20190603.core.ConteatInterfac;
import com.fy.fanying20190603.greendao.dao.DaoMaster;
import com.fy.fanying20190603.greendao.dao.ResultDao;
import com.fy.fanying20190603.presenter.MyPresneter;
import com.fy.fanying20190603.view.TitleSou;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:50
 * @Description：描述信息
 */
public class ShouFragment extends Fragment implements ConteatInterfac.Fragment1Interfac {
    ConteatInterfac.PresenterInterfac presenterInterfac;
    String str = "高跟鞋";
    List<Result> list = new ArrayList<>();
    @BindView(R.id.tite_sou)
    TitleSou titeSou;
    @BindView(R.id.recyc_view)
    RecyclerView recycView;
    Unbinder unbinder;
    @BindView(R.id.liner_layout)
    LinearLayout linerLayout;
    private Fragment1Adapter adapter;
    private ResultDao dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dao = DaoMaster.newDevSession(getActivity(),ResultDao.TABLENAME).getResultDao();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recycView.setLayoutManager(layoutManager);
        adapter = new Fragment1Adapter(list, getActivity());
        recycView.setAdapter(adapter);
        presenterInterfac = new MyPresneter<>(this);
        presenterInterfac.getResultsss(str);
        titeSou.setMyCallBack(new TitleSou.MyCallBack() {
            @Override
            public void stringdsadf(String json) {
                presenterInterfac.getResultsss(json);
            }
        });


        adapter.setMyCallBack(new Fragment1Adapter.MyCallBack() {
            @Override
            public void onclicklinser(View view, final Result result) {
                ObjectAnimator  animator = ObjectAnimator.ofFloat(view,"translationY",0f,200f);
                animator.setDuration(3000);
                animator.start();

                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        EventBus.getDefault().postSticky(result);
                        Intent intent  = new Intent(getActivity(),XiangQingActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }
        });


    }

    @Override
    public void showResultsss(Object object) {
        list.clear();
        SouBean souBean = (SouBean) object;
        list.addAll(souBean.getResult());
        Log.e("aaa", souBean.toString());
        adapter.notifyDataSetChanged();
        dao.insertOrReplaceInTx(list );
        if (list.size() == 0) {
            linerLayout.setVisibility(View.VISIBLE);
            recycView.setVisibility(View.GONE);
        }else{
            linerLayout.setVisibility(View.GONE);
            recycView.setVisibility(View.VISIBLE);
        }
    }
    //解绑
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if(presenterInterfac!=null){
            presenterInterfac.onDestory();
        }
    }

    MyCallBack myCallBack;

    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    public interface MyCallBack{
        public void onclicklinser(long id);
    }
}
