package com.exchange.rate.exchrate.dtos;

public enum DataSource {
    NationalBank(1), PrivateBank(2), MonoBank(3), MinFin(4);

    int val;

    DataSource(int i) {
        this.val = i;
    }

    public int getVal() {
        return val;
    }
}
