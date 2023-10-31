package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public String[] getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        InputValidation.validateCarNames(carNames);

        return carNames;
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();
        InputValidation.validateTryCount(tryCount);

        return Integer.parseInt(tryCount);
    }
}
