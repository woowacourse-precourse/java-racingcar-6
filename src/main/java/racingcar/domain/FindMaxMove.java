package racingcar.domain;

import java.util.HashMap;
import java.util.List;

public class FindMaxMove {
    public static int findMaxMove(HashMap<String,Integer> car_list){
        int maxMove = 0;

        for (int car_move : car_list.values()) {
            if (car_move >= maxMove) {
                maxMove = car_move;
            }
        }
        return maxMove;
    }
}
