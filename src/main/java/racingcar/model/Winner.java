package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;


public class Winner {
    private ArrayList<String> winnerList = new ArrayList<>();

    public void decideWinner(int[] ranking, ArrayList<String> cars) {
        for (int idx = 0; idx < ranking.length; idx++) {
            validateWinner(ranking, cars, idx);
        }
    }

    //validateWinner 속도 개선 필요
    public void validateWinner(int[] ranking, ArrayList<String> cars, int idx) {
        if (ranking[idx] == Arrays.stream(ranking).max().getAsInt()) {
            addToWinnerList(cars, idx);
        }
    }

    public void addToWinnerList(ArrayList<String> cars, int idx) {
        winnerList.add(cars.get(idx));
    }


    public ArrayList<String> getWinnerList() {
        return winnerList;
    }
}
