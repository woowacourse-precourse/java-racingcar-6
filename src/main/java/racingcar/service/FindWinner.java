package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWinner {
    private final List<String> winner = new ArrayList<>();

    public int findMaxMove(HashMap<String, Integer> car_list) {
        int maxMove = 0;

        for (int car_move : car_list.values()) {
            maxMove = Math.max(maxMove, car_move);
        }
        return maxMove;
    }

    private void create_winnerList(Map.Entry<String, Integer> car, int winnerMove) {

        if (winnerMove == car.getValue()) {
            winner.add(car.getKey());
        }

    }

    public List<String> findWinner(HashMap<String, Integer> car_list) {
        int winnerMove = findMaxMove(car_list);

        for (Map.Entry<String, Integer> item : car_list.entrySet()) {
            create_winnerList(item, winnerMove);
        }

        return winner;
    }
}