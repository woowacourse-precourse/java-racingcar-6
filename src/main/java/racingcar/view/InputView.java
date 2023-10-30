package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String rawInputString = Console.readLine();

        if(rawInputString == null || rawInputString.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }

        return rawInputString;
    }

    public static String requestInputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String rawInputString = Console.readLine();

        if(rawInputString == null || rawInputString.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }

        return rawInputString;
    }
}
