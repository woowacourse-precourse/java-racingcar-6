package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class StartCondition {
    public String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        checkInputCarName(carName);
        return carName.split(",");
    }

    public void checkInputCarName(String carName) {
        String[] racerNames = carName.split(",");
        for (String racerName : racerNames) {
            if (racerName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        checkAttemptNumber(input);
        return Integer.parseInt(input);
    }

    public void checkAttemptNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
