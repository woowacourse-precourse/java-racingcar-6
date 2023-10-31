package racingcar.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.global.enums.ErrorMessage.EMPTY_INPUT_VALUE;
import static racingcar.global.enums.ErrorMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.global.enums.ErrorMessage.INVALID_NUMBER_FORMAT;
import static racingcar.global.enums.GuideMessage.INPUT_CAR_LIST_COMMAND;
import static racingcar.global.enums.GuideMessage.INPUT_ROUND_CNT_COMMAND;

public final class GameInput {

    public static int inputRoundCnt() {
        System.out.println(INPUT_ROUND_CNT_COMMAND);
        String input = readLine();
        return validateCnt(input);
    }

    public static int validateCnt(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_VALUE.getType());
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getType());
        }
    }

    public static String[] inputCarList() {
        System.out.println(INPUT_CAR_LIST_COMMAND);
        String[] carList = readLine().trim().split(",\\s*");
        validateCarList(carList);
        return carList;
    }

    public static void validateCarList(String[] carList) {
        if (carList[0].equals("") || carList.length == 0) {
            throw new IllegalArgumentException(EMPTY_INPUT_VALUE.getType());
        }

        for (String s : carList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getType());
            }
        }
    }
}
