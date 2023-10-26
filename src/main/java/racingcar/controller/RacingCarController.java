package racingcar.controller;

import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final String COMMA =",";
    public void run(){start();}

    public void start(){
        racingCarGameStart();
    }

    private void racingCarGameStart() {

        RacingCarValidator.racingCarNameLengthValidator(requestRacingCarNameList());
        requestAttemptNumberInput();
    }


    private List<String> requestRacingCarNameList(){
        return racingCarNameConvertStringToArray(racingCarNameInput());
    }

    public List<String> racingCarNameConvertStringToArray(String racingCar){
       return Arrays.stream(racingCar.split(COMMA))
                .collect(Collectors.toList());
    }

    private String racingCarNameInput(){
        return InputView.racingCarNameInput();
    }

    private Integer requestAttemptNumberInput(){
        String number = InputView.attemptNumberInput();
        RacingCarValidator.attemptOnlyInputNumber(number);
        return Integer.parseInt(number);
    }

}
