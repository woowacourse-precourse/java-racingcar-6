package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_NAMES_FORMAT = "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)%n";

    public static String readNames(String delimiterName, String delimiterShape) {
        System.out.format(READ_NAMES_FORMAT, delimiterName, delimiterShape);

        return Console.readLine().trim();
    }
}
