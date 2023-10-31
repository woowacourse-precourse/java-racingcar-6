package racingcar.executionprocess;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Result {
    static int[] move;
    public Result(int[] move) {
        this.move = move;
    }
    public void output(List<String> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (pickCarRandomNum()) {
                move[i]++;
            }
        }
        for(int j = 0; j < move.length; j++) {
            System.out.println(cars.get(j)+ " : " + "-".repeat(move[j]));
        }
    }

    private boolean pickCarRandomNum() {
        int number = Randoms.pickNumberInRange(0,9);
        if (number >= 4) {
            return true;
        }
        return false;
    }


    public String findWinner(List<String> cars) {
        int max = findMaxMove(0,move.length-1);
        List<String> winCar = new ArrayList<>();
        for(int j = 0; j < cars.size(); j++) {
            if (move[j] == max) {
                winCar.add(cars.get(j));
            }
        }
        String winner = String.join(", ", winCar);
        return winner;
    }

    public int findMaxMove(int left, int right) {
        int half;
        if(left == right) {
            return move[left];
        }
        half = (left+right)/2;
        return Math.max(findMaxMove(left, half), findMaxMove(half+1, right));
    }
}
