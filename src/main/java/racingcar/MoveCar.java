package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveCar {
    public String CarMove(int move){
        String position = "";
        for(int i = 0; i<move; i++){
            position+="-";
//            System.out.println(position);
        }
        return position;
    }



    //자동차 이동 클래스
//    public void PrintResult(List<HashMap<String, Integer>> carHashMapList){
//        for(HashMap<String,Integer> hashMap : carHashMapList){
//            for (Map.Entry<String, Integer> m : hashMap.entrySet()) {
//                String player = m.getKey();
//                int move = hashMap.get(player);
//                CalculateMove();
//            }
//        }

//    }
}
