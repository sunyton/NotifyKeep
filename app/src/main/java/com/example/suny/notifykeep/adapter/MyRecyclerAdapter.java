package com.example.suny.notifykeep.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suny.notifykeep.R;
import com.example.suny.notifykeep.utils.databases.Datas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suny on 2017/5/10.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    List<Datas> mDatasList;
    Context mContext;

    public MyRecyclerAdapter(List<Datas> mDatasList,Context context) {
        this.mDatasList = mDatasList;
        mContext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        String appName = "";
        final PackageManager pm = mContext.getPackageManager();
        try {
             appName = (String) pm.getApplicationLabel(pm.getApplicationInfo(mDatasList.get(position).getAppName(),PackageManager.GET_META_DATA));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        holder.tvAppName.setText(appName);
        holder.tvBody.setText(mDatasList.get(position).getBody());
        try {
            holder.imAppIcon.setImageDrawable(mContext.getPackageManager().getApplicationIcon(mDatasList.get(position).getAppName()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mDatasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvAppName;
        TextView tvBody;
        ImageView imAppIcon;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvAppName = (TextView) itemView.findViewById(R.id.tv_name);
            tvBody = (TextView) itemView.findViewById(R.id.tv_body);
            imAppIcon = (ImageView) itemView.findViewById(R.id.im_keep);
        }
    }
}
