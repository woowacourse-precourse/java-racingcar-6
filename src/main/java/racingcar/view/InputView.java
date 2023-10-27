package racingcar.view;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.ExceptionMessage.*;
import static racingcar.constant.RaceIOMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.controller.Validation;

public class InputView {
    private final Validation validation;

    public InputView() {
        validation = new Validation();
    }
    public Map<String, Integer> inputCarName() {
        System.out.println(CAR_NAME_INPUT);
        String nameInput = Console.readLine();
        validateInputBlank(nameInput);
        validation.NameLengthZero(nameInput);
        // 자동차 이름 입력 관련 2차 유효성 검사
        Map<String, Integer> carList = new LinkedHashMap<>();
        for (String carName : nameInput.split(DELIMETER)) {
            validation.OverNameLengthLimit(carName);
            validation.NameDuplicated(carName, carList);
            carList.put(carName, 0);
        }
        return carList;
    }
    public int inputRounds() {
        System.out.println(NUMBER_INPUT);
        String roundsInput = Console.readLine();
        validateInputBlank(roundsInput);
        return validation.RoundsNumeric(roundsInput);
    }

    public void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }
}