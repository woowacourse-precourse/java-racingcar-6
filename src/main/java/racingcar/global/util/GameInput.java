package racingcar.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.global.enums.ErrorMessage.EMPTY_INPUT_VALUE;
import static racingcar.global.enums.ErrorMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.global.enums.ErrorMessage.INVALID_NUMBER_FORMAT;
import static racingcar.global.enums.GuideMessage.INPUT_CAR_LIST_COMMAND;
import static racingcar.global.enums.GuideMessage.INPUT_ROUND_CNT_COMMAND;

public final class GameInput {

    /**
     * 종료할 차수의 입력을 담당하는 메서드
     * @return
     */
    public static int inputRoundCnt() {
        System.out.println(INPUT_ROUND_CNT_COMMAND);
        String input = readLine();
        return validateCnt(input);
    }

    /**
     * 차수 입력에 대한 예외처리 메서드
     * - 유효하지 않은 값의 입력은 IllegalArgumentException으로 비정상 처리한다.
     * @param input
     * @return
     */
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

    /**
     * 차량의 이름 리스트 입력을 담당하는 메서드
     * @return
     */
    public static String[] inputCarList() {
        System.out.println(INPUT_CAR_LIST_COMMAND);
        String[] carList = readLine().trim().split(",\\s*");
        validateCarList(carList);
        return carList;
    }

    /**
     * 차량 리스트의 입력에 대한 예외처리 메서드
     * @param carList
     */
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
