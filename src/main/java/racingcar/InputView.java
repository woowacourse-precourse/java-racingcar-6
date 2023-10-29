package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TIMES_TO_TRY_REQUEST = "시도할 횟수는 몇회인가요?";

    public static String carName() {
        System.out.println(CAR_NAME_REQUEST);
        String carNamesString;
        try {
            carNamesString = readLine();
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_LENGTH_OVERED);
        }
        return carNamesString;
    }

    public static int timesToTry() {
        System.out.println(TIMES_TO_TRY_REQUEST);
        int timesToTry;
        try {
            timesToTry = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_TYPE_MISMATCH);
        }
        return timesToTry;
    }

}
