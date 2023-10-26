package racingcar.controller;

import racingcar.service.Accelerator;
import racingcar.service.Judgement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String cars = inputView.readCars();
        List<String> names = List.of(cars.split(","));
        int round = Integer.parseInt(inputView.readRound());
        Map<String, Integer> position = new HashMap<>();

        for (String name : names) {
            position.put(name, 0);
        }

        outputView.printExecution();

        for (int i = 0; i < round; i++) {
            play(position);
            outputView.printResult(position);
            System.out.println();
        }
        outputView.printFinalWinner(Judgement.choseWinner(position));
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
