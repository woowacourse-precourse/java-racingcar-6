package racingcar.utils;

import static racingcar.message.ErrorMessage.CAR_NAME_HAVE_WHITE_CHAR;
import static racingcar.message.ErrorMessage.CAR_NAME_IS_BIGGER_THAN_5CHAR;
import static racingcar.message.ErrorMessage.CAR_NAME_IS_DUPLICATED;
import static racingcar.message.ErrorMessage.CAR_NAME_IS_EMPTY;
import static racingcar.message.ErrorMessage.MOVE_COUNT_IS_NOT_NUM;
import static racingcar.message.ErrorMessage.MOVE_COUNT_IS_NOT_POSITIVE_NUM;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarUtil {
    public static boolean validateCarNamesInput(String input) {
        String noWhiteSpaceInput = input.replace(" ", "");
        if (noWhiteSpaceInput.length() != input.length()) {
            throw new IllegalArgumentException(CAR_NAME_HAVE_WHITE_CHAR.getMessage());
        }
        return true;
    }

    public static boolean validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException(MOVE_COUNT_IS_NOT_POSITIVE_NUM.getMessage());
        }
        return true;
    }

    public static boolean validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MOVE_COUNT_IS_NOT_NUM.getMessage());
        }
        return true;
    }

    public static boolean validateCarList(List<RacingCar> carList) {
        for (RacingCar car : carList) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_IS_BIGGER_THAN_5CHAR.getMessage());
            }
            if (car.getName().isEmpty()) {
                throw new IllegalArgumentException(CAR_NAME_IS_EMPTY.getMessage());
            }
        }
        return true;
    }

    public static boolean validateDuplication(String[] arr) {
        List<String> tempArr = new ArrayList<>();
        for (String e : arr) {
            if (tempArr.contains(e)) {
                throw new IllegalArgumentException(CAR_NAME_IS_DUPLICATED.getMessage());
            }
            tempArr.add(e);
        }
        return true;
    }
}
