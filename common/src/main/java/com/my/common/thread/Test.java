package com.my.common.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wenlf
 * @since 2018/5/4
 */
public class Test {

    public void Test1(){
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<String,Object>();

        HashMap<String, Object> hashMap = new HashMap<>(10);

        List<Integer> integers = new ArrayList<>();

        List<Integer> integers1 = new LinkedList<>();
    }
}
