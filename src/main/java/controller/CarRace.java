package controller;

import view.InputView;

import java.util.Arrays;
import java.util.List;

public class CarRace {
    private String getCarNameByInput() {
        InputView inputView = new InputView();
        String carName = inputView.printUserInputCarNameMessage();
        return carName;
    }

    private List<String> parseCarName(String input) {
        List<String> carName = Arrays.asList(input);
        return carName;
    }
}
