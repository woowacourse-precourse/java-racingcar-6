package racingcar;

import java.util.List;

public class RacingCarGame {

    private RacingCars racingCars;
    private long numOfMoves;
    private int maxAdvance;

    public RacingCarGame(String[] carNames, long numOfMoves) {
        racingCars = new RacingCars(carNames);
        this.numOfMoves = numOfMoves;
    }

    public List<Result> run() {
        System.out.println("실행 결과");
        for (int i = 0; i < numOfMoves; i++) {
            racingCars.moveCars();
        }

        return racingCars.findWinner();
    }
}
