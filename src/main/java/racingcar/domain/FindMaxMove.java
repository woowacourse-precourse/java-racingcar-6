package racingcar.domain;

import java.util.HashMap;

public class FindMaxMove {
    public static int findMaxMove(HashMap<String,Integer> car_list){
        int maxMove = 0;

        for (int car_move : car_list.values()) {
            maxMove = Math.max(maxMove, car_move);
        }
        return maxMove;
    }
}
