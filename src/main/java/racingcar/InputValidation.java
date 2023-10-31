package racingcar;

import java.util.Arrays;

import static racingcar.MessageConst.STANDARD_SAPARATOR;
import static racingcar.NumberConst.*;

public class InputValidation {

    private static String replaceRegexChar = "[가-힣a-zA-Z0-9,]";
    private static String replaceReplacementChar = "";

    public static void validateInputCorrectSeparator(String userInputCarName) {
        String deleteAllWords = userInputCarName.replaceAll(replaceRegexChar, replaceReplacementChar);
        if (deleteAllWords.length() != 0) {
            throw new IllegalArgumentException("이름은 " + STANDARD_SAPARATOR + "로 구분하여 입력하세요.");
        }
    }

    public static void validateNameOfCarsLength(String[] namesOfCars) {
        for (String name : namesOfCars) {
            if (name.length() < MIN_NAME_OF_CAR_LENGTH || name.length() > MAX_NAME_OF_CAR_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_OF_CAR_LENGTH + "자 이하로 입력하세요.");
            }
        }
    }

    public static void validateDuplicateName(String[] namesOfCars) {
        Object[] deleteDuplicateName = Arrays.stream(namesOfCars).distinct().toArray();
        if (deleteDuplicateName.length != namesOfCars.length) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다.");
        }
    }

    public static void validateMoveCountRange(int carMovingCount) {
        if (carMovingCount < MOVING_MIN_COUNT || carMovingCount > MOVING_MAX_COUNT) {
            throw new IllegalArgumentException("이동 횟수는" + MOVING_MAX_COUNT + "회 이하로 입력하세요.");
        }
    }
}
