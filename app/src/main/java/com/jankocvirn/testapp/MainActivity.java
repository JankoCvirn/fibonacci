package com.jankocvirn.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jankocvirn.testapp.adapter.ResultsAdapter;
import com.jankocvirn.testapp.model.Result;
import com.jankocvirn.testapp.service.FibonacciService;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recycler) RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ResultsAdapter resultsAdapter;

    @Override public void onStart () {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override public void onStop () {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        resultsAdapter = new ResultsAdapter();
        recyclerView.setAdapter(resultsAdapter);
        resultsAdapter.addResult(new Result(100, 100));

        Intent i = new Intent(getApplicationContext(), FibonacciService.class);
        getApplicationContext().startService(i);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) public void onMessageEvent (Result result) {
        resultsAdapter.addResult(result);
    }
}
