package racingcar.view;

import static racingcar.system.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.assist.InputValidator;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(){
        inputValidator = new InputValidator();
    }

    public List<String> requestCarNamesInput(){
        System.out.println(INPUT_CAR_NAMES_MESSAGE.getMessage());
        String carNames = Console.readLine();
        List<String> carNameList = generateCarNameListByCarNames(carNames);
        inputValidator.validateCarNamesInput(carNameList);
        return carNameList;
    }

    public int requestRepeatTimesInput(){
        System.out.println(INPUT_REPEAT_TIMES_MESSAGE.getMessage());
        String repeatTimes = Console.readLine();
        inputValidator.validateRepeatTimesInput(repeatTimes);
        return Integer.parseInt(repeatTimes);
    }

    private static List<String> generateCarNameListByCarNames(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return carNameList;
    }
}
