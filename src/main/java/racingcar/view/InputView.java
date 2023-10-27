package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String inputRacingCarsNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String inputCountMessage = "시도할 회수는 몇회인가요?";

    public static String inputRacingCarsName() {
        System.out.println(inputRacingCarsNameMessage);
        return Console.readLine();
    }

    public static String inputCount() {
        System.out.println(inputCountMessage);
        return Console.readLine();
    }
}
