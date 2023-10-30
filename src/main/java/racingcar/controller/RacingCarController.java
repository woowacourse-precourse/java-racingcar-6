package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Move;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingCarController {
    public RacingCarController() {
    }

    public void startGame() {
        ArrayList<String> cars = Car.inputNames();
        HashMap<String, Integer> carsMap = Car.makeMap(cars);
        int tries = Move.inputNumberOfTries();
        for (int i = 0; i < tries; i++) {
            playGame();
        }
    }

    public void playGame() {

    }

    public String takeWinners() {
        return null;
    }
}
