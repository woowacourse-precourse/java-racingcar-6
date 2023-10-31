package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.InputValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame(){
        outputView.gameStartMessage();
        getCarNamesInput();
        getTriesInput();
    }

    private Integer getTriesInput(){
        String input = inputView.readTriesInput();
        InputValidation.validateTriesInput(input);
        return Integer.parseInt(input);
    }

    private List<String> getCarNamesInput(){
        String input = inputView.readCarNamesInput();
        String[] splitInputNames = input.split(",");
        List<String> inputNames = Arrays.asList(splitInputNames);
        InputValidation.validateCarNamesInput(inputNames);
        return inputNames;
    }
}
