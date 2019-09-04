package com.jankocvirn.testapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jankocvirn.testapp.R;
import com.jankocvirn.testapp.model.Result;
import java.util.ArrayList;
import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private final List<Result> resultList = new ArrayList<>();

    @Override public ResultViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_item, parent, false);
        ResultViewHolder resultViewHolder = new ResultViewHolder(v);
        return resultViewHolder;
    }

    @Override public void onBindViewHolder (ResultViewHolder holder, int position) {

        Result result = resultList.get(position);
        holder.setTxtResult("f(" + result.getI() + ")=" + result.getResult());
    }

    public void addResult (Result result) {

        this.resultList.add(result);
        notifyDataSetChanged();
    }

    @Override public int getItemCount () {
        return resultList.size();
    }
}
