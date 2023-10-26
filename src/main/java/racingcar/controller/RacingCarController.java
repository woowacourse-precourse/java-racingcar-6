package racingcar.controller;

import racingcar.service.Accelerator;
import racingcar.view.InputView;

import java.util.HashMap;
import java.util.Map;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String cars = inputView.readCars();
        String[] names = cars.split(",");
        int round = Integer.parseInt(inputView.readRound());
        Map<String, Integer> position = new HashMap<>();

        for (String name : names) {
            position.put(name, 0);
        }

        for (int i = 0; i < round; i++) {
            play(position);
        }
    }

    private void play(Map<String, Integer> position) {
        for (String name : position.keySet()) {
            if (Accelerator.canMoveForward()) {
                moveForward(position, name);
            }
        }
    }

    private void moveForward(Map<String, Integer> position, String name) {
        position.put(name, position.get(name) + 1);
    }
}
