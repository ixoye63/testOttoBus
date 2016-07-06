package com.tongtong.testottobus;

/**
 * Created by KOHeeJin on 2016-07-06.
 */
public class TestEvent2 {

    private String nFrom;
    private int nNum;


    public TestEvent2(String from, int num) {
        nFrom = from;
        nNum = num;
    }

    public int getTransNum(){
        return nNum;
    }
    public String getTransFrom(){
        return nFrom;
    }
}
