package racingcar.service;

import racingcar.domain.FindMaxMove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWinner {
    private List<String> winner = new ArrayList<>();

    private void create_winnerList(Map.Entry<String,Integer> car, int winnerMove){

        if (winnerMove == car.getValue()){
            winner.add(car.getKey());
        }

    }

    public List<String> findWinner(HashMap<String,Integer> car_list){
        int winnerMove = FindMaxMove.findMaxMove(car_list);

        for (Map.Entry<String, Integer> item : car_list.entrySet()) {
            create_winnerList(item, winnerMove);
        }

        return winner;
    }
}
