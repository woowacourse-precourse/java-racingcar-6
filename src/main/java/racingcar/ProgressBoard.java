package racingcar;

import java.util.HashMap;

public class ProgressBoard {
    private final HashMap<Car, String> SCORE_BOARD;
    private final String EMPTY_STRING = "";
    private static ProgressBoard INSTANCE = new ProgressBoard();

    private ProgressBoard() {
        SCORE_BOARD = new HashMap<>();
    }

    public static ProgressBoard getInstance() {
        return INSTANCE;
    }

    public void registerCar(Car car) {
        this.SCORE_BOARD.put(car, EMPTY_STRING);
    }


}
