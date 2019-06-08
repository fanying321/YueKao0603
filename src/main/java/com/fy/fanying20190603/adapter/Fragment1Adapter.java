package com.fy.fanying20190603.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fy.fanying20190603.R;
import com.fy.fanying20190603.bean.Result;

import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:45
 * @Description：描述信息
 */
public class Fragment1Adapter extends RecyclerView.Adapter<Fragment1Adapter.Holder> {
    List<Result> list ;
    Context context ;

    public Fragment1Adapter(List<Result> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_fragmentadapter,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {

        holder.sou_name.setText(list.get(i).getCommodityName());
        holder.sou_num.setText(list.get(i).getSaleNum()+"");
        holder.sou_price.setText(list.get(i).getPrice()+"");
        Glide.with(context).load(list.get(i).getMasterPic()).into(holder.image_sou);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result results = list.get(i);

                myCallBack.onclicklinser(v,results);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  Holder extends RecyclerView.ViewHolder {
        TextView sou_price,sou_num,sou_name;
        ImageView image_sou;
        public Holder(@NonNull View itemView) {
            super(itemView);
            sou_price = itemView.findViewById(R.id.sou_price);
            sou_num = itemView.findViewById(R.id.sou_num);
            sou_name = itemView.findViewById(R.id.sou_name);
            image_sou = itemView.findViewById(R.id.iamge_sou);
        }
    }
    MyCallBack myCallBack;

    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    public interface MyCallBack{
        public void onclicklinser(View view,Result result);
    }
}
