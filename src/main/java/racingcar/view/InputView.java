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
        // 자동차 이름 입력 관련 1차 유효성 검사
        if (nameInput.contains(DELIMETER)) {
            if (nameInput.charAt(0) == DELIMETER.charAt(0)
                    || nameInput.charAt(nameInput.length()-1) == DELIMETER.charAt(0)) {
                throw new IllegalArgumentException(NAME_LENGTH_ZERO + nameInput);
            }
            if (nameInput.contains(DELIMETER+DELIMETER)) {
                throw new IllegalArgumentException(NAME_LENGTH_ZERO + nameInput);
            }
        }
        // 자동차 이름 입력 관련 2차 유효성 검사
        Map<String, Integer> carList = new LinkedHashMap<>();
        for (String carName : nameInput.split(DELIMETER)) {
            if (carName.length() > NAME_LENGTH_MAX) {
                throw new IllegalArgumentException(OVER_NAME_LENGTH + carName);
            }
            if (carList.containsKey(carName)) {
                throw new IllegalArgumentException(NAME_DUPLICATED + carName);
            }
            carList.put(carName, 0);
        }
        return carList;
    }
    public int inputRounds() {
        System.out.println(NUMBER_INPUT);
        String countInput = Console.readLine();
        // 시도 횟수 유효성 검사
        int count;
        try {
            count = Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC + countInput);
        }
        return count;
    }
}