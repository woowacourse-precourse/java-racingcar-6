package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public static String askRacingCarNames() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String racingCars = Console.readLine();
        InputValidator.checkLength(racingCars);
        return racingCars;
    }

    public static int askTryCount() {
        System.out.println("시도할 횟수");
        String rxNum = Console.readLine();

        InputValidator.checkNum(rxNum);

        int tryCount = Integer.parseInt(rxNum);

        return tryCount;
    }
}
