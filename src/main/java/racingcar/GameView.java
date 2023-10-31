package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Game;

public class GameView {

    ExceptionHandler exceptionHandler = new ExceptionHandler();

    public String inputNameOfCars() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        exceptionHandler.validateUserInput(userInput);
        return userInput;
    }

    public Integer inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfAttempts = Console.readLine();
        exceptionHandler.validateNumberOfAttempts(numberOfAttempts);
        return Integer.parseInt(numberOfAttempts);
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printResultOfRound(Game game) {
        game.printResultOfRound();
        System.out.println();
    }

}
