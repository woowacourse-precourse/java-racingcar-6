package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
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
}
