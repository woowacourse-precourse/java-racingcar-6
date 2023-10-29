package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class UserInputer {

    public String inputCarString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        return userInput;
    }

    public String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();

        return userInput;
    }

    
}
