package racingcar;

import java.util.HashMap;
import java.util.List;

public class ProgressBoard {
    private final HashMap<String, String> SCORE_BOARD;
    private final String EMPTY_STRING = "";
    private final String MOVE_STRING = "-";
    private static ProgressBoard INSTANCE = new ProgressBoard();

    private ProgressBoard() {
        this.SCORE_BOARD = new HashMap<>();
    }

    public static ProgressBoard getInstance() {
        return INSTANCE;
    }

    public void registerCars(List<String> cars) {
        for (String carName : cars) {
            this.SCORE_BOARD.put(carName, EMPTY_STRING);
        }
    }

    public void moveForward(String carName) {
        this.SCORE_BOARD.put(carName, this.SCORE_BOARD.get(carName) + MOVE_STRING);
    }

    public String progressOf(String carName) {
        return this.SCORE_BOARD.get(carName);
    }


}
