package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.CarNameIncorrectException;

/**
 * - 경주할 자동자 이름 입력 기능 - 경주할 자동차 이름들은 입력 받는다. ( camp.nextstep.edu.missionutils.Console의 readLine() ) - 입력 받은 이름은 쉼표로 구분
 * 하여 관리 - 입력 받은 이름 중 5자 이하 인지 확인 - 5자 이하인 경우 정상 진행 - 5자 초과인 경우 IllegalArgumentException 예외 발생
 */
public class InputView {

    private InputView() {
    }

    public static String getCarNames() {
        String carnames = Console.readLine();
        checkNullAndEmpty(carnames);
        return carnames;
    }

    public static void checkNullAndEmpty(String str) {
        isNull(str);
        isEmpty(str);
    }


    private static void isNull(String str) {
        if (str == null) {
            throw new CarNameIncorrectException("null 이 입력 되었습니다.");
        }
    }

    private static void isEmpty(String str) {
        if (str.trim().isEmpty()) {
            throw new CarNameIncorrectException("빈값 이 입력 되었습니다.");
        }
    }
}
