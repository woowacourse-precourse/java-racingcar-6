package racingcar;

import java.util.List;

public class RacingCarGame {

    private RacingCars racingCars;
    private long numOfMoves;

    public RacingCarGame(String[] carNames, long numOfMoves) {
        racingCars = new RacingCars(carNames);
        this.numOfMoves = numOfMoves;
    }

    public void run() {
        for (int i = 0; i < numOfMoves; i++) {
            racingCars.moveCars();
        }

        List<String> results = racingCars.reportResults();
    }
}
