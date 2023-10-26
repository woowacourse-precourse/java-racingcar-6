package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String printNameToBeInput () {
        System.out.println("경주할 자동차 이름을 입력하세요.(임르은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String printNumToBeInput () {
        System.out.println("시도할 회수는 몇번인가요?");
        return Console.readLine();
    }
}
