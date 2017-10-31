package com.jankocvirn.testapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jankocvirn.testapp.R;

/**
 * TestApp
 * com.jankocvirn.testapp.adapter
 * Created by janko on 31.10.17..
 * Description:
 * Usage:
 */

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
