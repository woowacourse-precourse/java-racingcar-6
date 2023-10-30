package racingcar.domain;

import java.util.ArrayList;

public class RacingBoard {
    private ArrayList<Car> board = new ArrayList<>();

    public void join(int num, Car car) {
        board.set(num, car);
    }

    public void write(ArrayList<Car> board) {
        this.board = board;
    }

    public ArrayList<Car> view() {
        return board;
    }
}
