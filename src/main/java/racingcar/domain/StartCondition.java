package racingcar.domain;

import camp.nextstep.edu.missionutils.Console

public class StartCondition {
    public String[] ipuntCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        checkInputCarName(carName);
        return carName.split(",");
    }

    private void checkInputCarName(String carNames) {
    }

    public int inputAttemptNumber() {
        return 0;
    }
}
