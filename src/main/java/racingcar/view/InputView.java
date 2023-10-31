package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CNT = "시도할 회수는 몇회인가요?";

    public static String inputName() {
        System.out.println(INPUT_CAR);
        return Console.readLine();
    }

    public static String inputCnt() {
        System.out.println(INPUT_CNT);
        return Console.readLine();
    }
}
