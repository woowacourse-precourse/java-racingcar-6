package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames  = Console.readLine();

        return carNames;
    }

    public String getStringOfTimes() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String stringOfTimes = Console.readLine();

        return stringOfTimes;
    }
}
