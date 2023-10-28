package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.UserInputValidator;

public class UserInput {
    public String inputCarsName() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsName = Console.readLine();
        UserInputValidator.carNameIsValid(carsName);

        return carsName;
    }

    public String inputCount() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        String cnt = Console.readLine();
        UserInputValidator.attemptCountIsValid(cnt);

        return cnt;
    }
}
