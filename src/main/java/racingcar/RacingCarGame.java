package racingcar;

import java.util.List;

public class RacingCarGame {

    private static final int START_NUM = 0;
    private static final int END_NUM = 9;

    private RacingCars racingCars;
    private long numOfMoves;

    private moveNumGenerator moveNumGenerator;

    public RacingCarGame(String[] carNames, long numOfMoves) {
        racingCars = new RacingCars(carNames);
        this.numOfMoves = numOfMoves;
        this.moveNumGenerator = new moveNumGenerator(START_NUM, END_NUM);
    }

    public List<Result> run() {
        for (int i = 0; i < numOfMoves; i++) {
            List<Result> results = racingCars.moveCars(moveNumGenerator.generate());
            printResults(results);
        }

        return racingCars.findWinners();
    }

    private static void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.println(result);
        }
        System.out.println();
    }
}
