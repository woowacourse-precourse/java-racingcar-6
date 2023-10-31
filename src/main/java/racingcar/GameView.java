package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    ExceptionHandler exceptionHandler = new ExceptionHandler();

    public String inputNameOfCars() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        exceptionHandler.validateUserInput(userInput);
        return userInput;
    }


}
