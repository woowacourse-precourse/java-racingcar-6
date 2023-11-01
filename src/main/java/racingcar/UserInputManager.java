package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInputManager {

    public String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        return carsInput.split(",");
    }

    public int inputAttempts() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int attempts = Integer.parseInt(Console.readLine());
        return attempts;
    }

}
