package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//        System.out.println("input car name.(name split , ");
        return Console.readLine();
    }

    public static String inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
//        System.out.println("how many attempt");
        return Console.readLine();
    }
}