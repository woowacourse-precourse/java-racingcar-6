package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGameInput {
    public static String ERROR_MESSAGE_BIGGER_THAN_5CHAR = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    public static String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    public static String ERROR_MESSAGE_NOT_POSITIVE = "[ERROR] 시도 횟수는 1 이상이어야 합니다.";

    public static List<RacingCar> readCarNames() {
        String[] arr = Console.readLine().split(",");
        List<RacingCar> carList = Arrays.stream(arr)
                .map(RacingCar::new)
                .toList();
        validateCarNames(carList);
        return carList;
    }

    public static boolean validateCarNames(List<RacingCar> carList) {
        for (RacingCar car : carList) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(ERROR_MESSAGE_BIGGER_THAN_5CHAR);
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

    public static boolean validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
        }
        return true;
    }

    public static boolean validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_POSITIVE);
        }
        return true;
    }

}
