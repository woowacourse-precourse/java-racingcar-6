package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    /* 자동차 이름을 입력받아 문자열 배열로 반환 */
    public static String[] inputCarNames() {
        String carNames = Console.readLine();
        return carNames.split(",");
    }

    /* 몇 번 이동을 할 것인지 시도할 횟수 입력 및 반환 */
    public static int inputNumberOfTries() {
        String numberOfTries = Console.readLine();
        return Integer.parseInt(numberOfTries);
    }
}
