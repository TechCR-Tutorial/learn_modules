package com.threadlocal;

import java.text.SimpleDateFormat;

public class LocalThreadLocal extends ThreadLocal<SimpleDateFormat> {

    @Override
    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public SimpleDateFormat get() {
        return super.get();
    }

    @Override
    public void remove() {
        super.remove();
    }
}
