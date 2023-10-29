package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameOfCars = Console.readLine();

        UserInput userInput = new UserInput(nameOfCars);
        userInput.checkValidity();

        System.out.println("시도할 회수는 몇회인가요?");
    }
}
