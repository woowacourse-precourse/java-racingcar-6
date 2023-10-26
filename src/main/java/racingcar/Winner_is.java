package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Input_car.car_map;

public class Winner_is {
    public static void winner_is() {
        int max = Integer.MIN_VALUE;
        List<String> winner_list = new ArrayList<>();


        for(String k : car_map.keySet()){
            if(max<car_map.get(k)){
                max = car_map.get(k);
            }
        }
        for(String k : car_map.keySet()){
            if(max<=car_map.get(k)){
                winner_list.add(k);
            }
        }
        String winner = String.join(",", winner_list);

        System.out.println("최종 우승자 : " + winner);

    }
}
