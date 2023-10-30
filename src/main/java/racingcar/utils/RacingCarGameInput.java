package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGameInput {
    public static final String ERROR_MESSAGE_BIGGER_THAN_5CHAR = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_NOT_POSITIVE = "[ERROR] 시도 횟수는 1 이상이어야 합니다.";
    public static final String ERROR_MESSAGE_HAVE_WHITE_CHAR = "[ERROR] 자동차 이름에 공백이 있을 수 없습니다.";
    public static final String ERROR_MESSAGE_DUPLICATION = "[ERROR] 자동차 이름이 중복되면 안됩니다.";
    public static final String ERROR_MESSAGE_EMPTY = "[ERROR] 자동차 이름이 비어 있을 수 없습니다.";

    public static List<RacingCar> readCarNames() {
        String input = Console.readLine();
        validateCarNamesInput(input);
        String[] arr = input.split(",");
        validateDuplication(arr);
        List<RacingCar> carList = Arrays.stream(arr)
                .map(RacingCar::new)
                .toList();
        validateCarList(carList);
        return carList;
    }

    private static boolean validateCarNamesInput(String input) {
        String noWhiteSpaceInput = input.replace(" ", "");
        if (noWhiteSpaceInput.length() != input.length()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HAVE_WHITE_CHAR);
        }
        return true;
    }

    private static boolean validateDuplication(String[] arr) {
        List<String> tempArr = new ArrayList<>();
        for (String e : arr) {
            if (tempArr.contains(e)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATION);
            }
            tempArr.add(e);
        }
        return true;
    }

    private static boolean validateCarList(List<RacingCar> carList) {
        for (RacingCar car : carList) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(ERROR_MESSAGE_BIGGER_THAN_5CHAR);
            }
            if (car.getName().isEmpty()) {
                throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY);
            }
        }
        return true;
    }

    public static int readMoveCount() {
        String input = Console.readLine();
        validateNumber(input);
        int moveCount = Integer.parseInt(input);
        validateMoveCount(moveCount);
        return moveCount;
    }

    private static boolean validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
        }
        return true;
    }

    private static boolean validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_POSITIVE);
        }
        return true;
    }

}
