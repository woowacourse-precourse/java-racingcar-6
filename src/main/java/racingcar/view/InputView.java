package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        System.out.println("참가할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
        return Console.readLine();
    }

    public static String getNumberRound() {
        System.out.println("시도할 회수를 입력하세요.");
        return Console.readLine();
    }
}