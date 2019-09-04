package com.jankocvirn.testapp.model;

public class Result {

    private long i;
    private long result;

    public long getI () {
        return i;
    }

    public void setI (long i) {
        this.i = i;
    }

    public long getResult () {
        return result;
    }

    public void setResult (long result) {
        this.result = result;
    }

    public Result () {
    }

    public Result (long i, long result) {
        this.i = i;
        this.result = result;
    }
}
