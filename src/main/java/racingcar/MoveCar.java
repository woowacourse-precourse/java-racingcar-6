package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveCar {
    public void CalculateMove(String player,int move){
        if(move>=4){
            System.out.printf("%s : - %n",player,move);
        } else {
            System.out.printf("%s : %n",player,move);
        }
    };
    //자동차 이동 클래스
    public void PrintResult(List<HashMap<String, Integer>> carHashMapList){
        for(HashMap<String,Integer> hashMap : carHashMapList){
            for (Map.Entry<String, Integer> m : hashMap.entrySet()) {
                String player = m.getKey();
                int move = hashMap.get(player);
//                System.out.println(key + " : " + value);
                CalculateMove(player,move);
            }
        }

    }
}
