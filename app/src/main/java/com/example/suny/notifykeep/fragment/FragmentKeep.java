package com.example.suny.notifykeep.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suny.notifykeep.R;
import com.example.suny.notifykeep.adapter.MyItemDecoration;
import com.example.suny.notifykeep.adapter.MyRecyclerAdapter;
import com.example.suny.notifykeep.utils.databases.DatabaseManager;
import com.example.suny.notifykeep.utils.databases.Datas;

import java.util.List;

/**
 * Created by suny on 2017/5/10.
 */

public class FragmentKeep extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keep, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_keep);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(init(), getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myRecyclerAdapter);
        recyclerView.addItemDecoration(new MyItemDecoration());
        return view;
    }
    public List<Datas> init() {

        DatabaseManager manager = new DatabaseManager(getActivity());

        List<Datas> list = manager.query("0");
        return list;
    }


}
