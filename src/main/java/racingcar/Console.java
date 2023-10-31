package racingcar;

import racingcar.constants.ConsoleMessage;
import racingcar.constants.ErrorMessage;
import racingcar.constants.Rule;

import java.util.Arrays;
import java.util.HashSet;

public class Console {
    public static void printInputCarName() {
        System.out.println(ConsoleMessage.INPUT_CAR_NAME);
    }

    public static void printInputTryCount() {
        System.out.println(ConsoleMessage.INPUT_TRY_COUNT);
    }

    public static void printResult() {
        System.out.println("\n" + ConsoleMessage.RESULT);
    }

    public static void printWinners(String[] winners) {
        System.out.print(ConsoleMessage.WINNER);
    }

    /**
     * 사용자 입력 받기
     *
     * @return 사용자 입력
     */
    private static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }


    /**
     * 자동차 이름 입력 받기
     *
     * @return 자동차 이름 리스트
     */
    public static String[] readCarName() {
        String input = validateInputIsEmpty(readLine());
        String[] carNames = Arrays.stream(input.split(","))
                .map(carName -> carName.trim()).toArray(String[]::new);

        for (String carName : carNames) {
            validateCarName(carName);
        }

        if (carNames.length != (new HashSet<String>(Arrays.asList(carNames))).size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME);
        }

        return carNames;
    }

    /**
     * 시도 횟수 입력 받기
     *
     * @return 시도 횟수
     */
    public static int readTryCount() {
        String input = validateInputIsEmpty(readLine());

        try {
            int tryCount = Integer.parseInt(input);
            validateTryCount(tryCount);

            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT);
        }
    }

    /**
     * 입력이 비어있는지 검증
     *
     * @param input
     * @return
     */
    private static String validateInputIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_NULL);
        }
        return input;
    }

    /**
     * 자동차 이름 검증
     *
     * @param carName
     */
    private static void validateCarName(String carName) throws IllegalArgumentException {
        if (carName.length() < Rule.MIN_CAR_NAME_LENGTH || carName.length() > Rule.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }

    /**
     * 시도 횟수 검증
     *
     * @param tryCount
     */
    private static void validateTryCount(int tryCount) throws IllegalArgumentException {
        if (tryCount < Rule.MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT_RANGE);
        }
    }

}
