package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    Exception errorHandling = new Exception();

    private void exceptionManager(String carName) {
        errorHandling.checkLength(carName);
        errorHandling.stringCompile(carName);
    }

    public String inputCarName() {
        System.out.println(START_MESSAGE);
        String carName = Console.readLine();
        exceptionManager(carName);
        return carName;
    }

    public int inputRound() {
        System.out.println(ROUND_MESSAGE);
        int round = Integer.parseInt(Console.readLine());
        errorHandling.checkNegativeValue(round);
        return round;
    }
}
