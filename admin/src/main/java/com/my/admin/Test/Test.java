package com.my.admin.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenlf
 * @since 2018/5/5
 */
public class Test {

    static final int TIME = 100000;

    public static void iteratorMap(Map<Integer, Integer> map, List<Double> list){
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int index = entry.getKey();
            int time  = entry.getValue();
            LotteryUtilTest result = new LotteryUtilTest(index, TIME, time, list.get(index));
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        //构造概率集合
        List<Double> list = new ArrayList<Double>();
        list.add(0.01d);
        list.add(0.30d);
        list.add(3d);
        list.add(26.69d);
        list.add(70d);
        LotteryUtil ll = new LotteryUtil(list);
        double sumProbability = ll.getMaxElement();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < TIME; i++){
            int index = ll.randomColunmIndex();
            if(map.containsKey(index)){
                map.put(index, map.get(index) + 1);
            }else{
                map.put(index, 1);
            }
        }
        for(int i = 0; i < list.size(); i++){
            double probability = list.get(i) / sumProbability;
            list.set(i, probability);
        }
        iteratorMap(map, list);

    }
}