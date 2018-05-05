package com.my.admin.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wenlf
 * @since 2018/5/5
 */
public class MyTest {

    public static void main(String[] args) {
        List<Prize> list = new ArrayList<>();
        Prize iphoneX = new Prize("iphoneX", 0D);

        Prize caijin88 = new Prize("88元彩金", 0.01D);

        Prize caijin10 = new Prize("10元彩金", 0.3D);

        Prize caijin2 = new Prize("2元彩金", 3D);

        Prize readBags2 = new Prize("2元红包", 26.69D);

        Prize thinks = new Prize("感谢参与", 70D);

        list.add(iphoneX);
        list.add(caijin88);
        list.add(caijin10);
        list.add(caijin2);
        list.add(readBags2);
        list.add(thinks);

        //list = list.stream().filter(prize -> prize.getOdds()!= 0d).collect(Collectors.toList());

        List<Double> chanceList = new ArrayList<>();
        for (Prize prize : list){
            chanceList.add(prize.getOdds());
        }
        //统计次数
        Map<String,Integer> tongji = new HashMap<>();

        LotteryUtil lotteryUtil = new LotteryUtil(chanceList);
        for(int i = 0 ; i < 100000 ; i++){
            Integer index = lotteryUtil.randomColunmIndex();
            Integer count = tongji.get(list.get(index).getName());
            if(count == null){
                tongji.put(list.get(index).getName(),1);
            }else{
                tongji.put(list.get(index).getName(),count+1);
            }
            //System.out.println("第"+(i+1)+"次抽奖，奖品为：" + list.get(index).getName());
        }

        for(String key : tongji.keySet()){
            System.out.println("奖品为：" + key + ",次数为："+tongji.get(key));
        }

    }
}
