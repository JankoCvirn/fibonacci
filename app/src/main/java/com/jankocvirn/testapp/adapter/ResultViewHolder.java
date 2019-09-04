package com.jankocvirn.testapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jankocvirn.testapp.R;


public class ResultViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.function) TextView txtResult;

    public ResultViewHolder (View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setTxtResult (String result) {

        txtResult.setText(result);
    }
}
