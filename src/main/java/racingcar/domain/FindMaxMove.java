package racingcar.domain;

import java.util.List;

public class FindMaxMove {
    public static int findMaxMove(List<Car> car_list){
        int maxMove = 0;

        for (int i = 0; i<car_list.size(); i++){
            int car_move = car_list.get(i).getMove();
            if (car_move >= maxMove){
                maxMove = car_move;
            }
        }
        return maxMove;
    }
}
