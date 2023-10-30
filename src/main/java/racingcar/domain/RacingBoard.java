package racingcar.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RacingBoard {
    private ArrayList<Car> board = new ArrayList<>();

    private ArrayList<String> winnerBoard = new ArrayList<>();

    public void join(int num, Car car) {
        board.set(num, car);
    }

    public void write(ArrayList<Car> board) {
        this.board = board;
    }

    public ArrayList<Car> view() {
        return board;
    }

    public void recordWinner(ArrayList<String> winnerBoard) {
        this.winnerBoard = winnerBoard;
    }

    public String viewWinner() {
        String result;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < winnerBoard.size(); i++) {
            temp.append(winnerBoard.get(i));
            if (i < (winnerBoard.size() - 1)) {
                temp.append(", ");
            }
        }
        result = temp.toString();
        return result;
    }
}
