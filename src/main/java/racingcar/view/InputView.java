package racingcar.view;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.ExceptionMessage.*;
import static racingcar.constant.RaceIOMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import java.util.Map;

public class InputView {
    public Map<String, Integer> inputCarName() {
        System.out.println(CAR_NAME_INPUT);
        String nameInput = Console.readLine();
        validateInputBlank(nameInput);
        validateNameLengthZero(nameInput);
        // 자동차 이름 입력 관련 2차 유효성 검사
        Map<String, Integer> carList = new LinkedHashMap<>();
        for (String carName : nameInput.split(DELIMETER)) {
            validateOverNameLengthLimit(carName);
            validateNameDuplicated(carName, carList);
            carList.put(carName, 0);
        }
        return carList;
    }
    public int inputRounds() {
        System.out.println(NUMBER_INPUT);
        String roundsInput = Console.readLine();
        validateInputBlank(roundsInput);
        return validateRoundsNumeric(roundsInput);
    }

    public void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }
    public void validateNameLengthZero(String carName) {
        int lastIndex = carName.length()-1;
        if (carName.contains(DELIMETER)) {
            if (carName.charAt(0) == DELIMETER.charAt(0) || carName.charAt(lastIndex) == DELIMETER.charAt(0)) {
                throw new IllegalArgumentException(NAME_LENGTH_ZERO + carName);
            }
            if (carName.contains(DELIMETER+DELIMETER)) {
                throw new IllegalArgumentException(NAME_LENGTH_ZERO + carName);
            }
        }
    }
    public void validateOverNameLengthLimit(String carName) {
        if (carName.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(OVER_NAME_LIMIT + carName);
        }
    }
    public void validateNameDuplicated(String carName, Map<String,Integer> carList) {
        if (carList.containsKey(carName)) {
            throw new IllegalArgumentException(NAME_DUPLICATED + carName);
        }
    }
    public int validateRoundsNumeric(String round) {
        int temp;
        try {
            temp = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC + round);
        }
        return temp;
    }
}