package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.FindMaxMove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWinner {
    public static List<String> findWinner(HashMap<String,Integer> car_list){
        List<String> winner = new ArrayList<>();
        int winnerMove = FindMaxMove.findMaxMove(car_list);

        for (Map.Entry<String, Integer> item : car_list.entrySet()) {
            if (item.getValue() == winnerMove) {
                winner.add(item.getKey());
            }
        }

        return winner;
    }
}
