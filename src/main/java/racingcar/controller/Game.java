package racingcar.controller;

import racingcar.view.Output;
import racingcar.view.Input;

import java.util.Arrays;
import java.util.List;

public class Game {
    private int attempt;
    public void run() {
        inputCar();
        inputTimes();
    }

    private void inputTimes() {
        Output.inputAttemptNumPrint();
        String input = Input.inputAttemptNum();
        attempt = Validator.validateInputAttemptNum(input);
    }
[]
    private void inputCar() {
        Output.inputCarsNamePrint();
        String input = Input.inputCarsName();
        List<String> string = Arrays.stream(input.split(",")).toList();
        Validator.validateInputCarList(string);
    }
}