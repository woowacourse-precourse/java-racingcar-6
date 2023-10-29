package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.FindMaxMove;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    public static List<String> findWinner(List<Car> car_list){
        List<String> winner = new ArrayList<>();
        int winnerMove = FindMaxMove.findMaxMove(car_list);

        for (int i = 0; i<car_list.size(); i++){
            Car currentCar = car_list.get(i);
            if (currentCar.getMove() == winnerMove){
                winner.add(currentCar.getName());
            }
        }

        return winner;
    }
}
