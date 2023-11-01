package racingcar.domain;

import racingcar.Input.UserInput;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Game {
    private RaceSimulator raceSimulator;
    private UserInput userInput;

    public Game() {
        this.raceSimulator = new RaceSimulator();
        this.userInput = new UserInput();
    }

    public void start() {
        LinkedHashMap<String, String> carNames = userInput.getCarNames();
        int numberOfMoves = userInput.getNumberOfMoves();
        System.out.println("");
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfMoves; i++) {
            carNames = raceSimulator.raceSimulation(carNames);
            RaceOutput.raceOutput(carNames);
        }
        RaceSimulator.raceWinner(carNames);
    }
}
