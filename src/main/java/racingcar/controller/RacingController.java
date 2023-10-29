package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    List<String> racingCars = new ArrayList<>();

    public void GameProgress() {

    }

    public void InputCarsByUser() {
        InputView.inputCars();
        String inputCars = Console.readLine();
        racingCars = List.of(inputCars.split(","));
    }

    public void InputAttemptsByUser() {
        InputView.inputAttemptsNum();
        int inputAttempts = Integer.parseInt(Console.readLine());
    }
}
