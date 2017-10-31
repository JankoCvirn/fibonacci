package com.jankocvirn.testapp.service;

import android.app.IntentService;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.jankocvirn.testapp.model.Result;
import org.greenrobot.eventbus.EventBus;

public class FibonacciService extends IntentService {

    public FibonacciService (String name) {
        super(name);
    }

    public FibonacciService () {
        super(null);
    }

    public static long fibonacci (long n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    @Nullable @Override public IBinder onBind (Intent intent) {
        return null;
    }

    @Override protected void onHandleIntent (@Nullable Intent intent) {
        long result = 0;
        long i = 0;

        while (result < Long.MAX_VALUE){

            result = fibonacci(i);
            Log.d("TEST", "Result:" + result);
            EventBus.getDefault().post(new Result(i, result));
            i++;
        }
    }
}
