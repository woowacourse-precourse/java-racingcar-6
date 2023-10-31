package racingcar.domain;

import java.util.HashMap;

public class Game {
    private RaceSimulator raceSimulator;
    private UserInput userInput;

    public Game() {
        this.raceSimulator = new RaceSimulator();
        this.userInput = new UserInput();
    }

    public void start() {
        HashMap<String, String> carNames = userInput.getCarNames();
        int numberOfMoves = userInput.getNumberOfMoves();
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfMoves; i++) {
            carNames = raceSimulator.raceSimulation(carNames);
            Output.raceOutput(carNames);
        }
    }
}
