package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
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
    public static List<String> findWinner(List<Car> car_list){
        List<String> winner = new ArrayList<>();
        int winnerMove = findMaxMove(car_list);

        for (int i = 0; i<car_list.size(); i++){
            Car currentCar = car_list.get(i);
            if (currentCar.getMove() == winnerMove){
                winner.add(currentCar.getName());
            }
        }

        return winner;
    }
}
