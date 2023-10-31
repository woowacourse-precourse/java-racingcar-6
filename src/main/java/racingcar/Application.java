package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.view.ConsoleUserInput;
import racingcar.view.RacingGameException;
import racingcar.view.UserInput;

public class Application {
    public static void main(String[] args) {
        try {
            UserInput userInput = new ConsoleUserInput();
            new RacingCarGame(userInput).run();
        } catch (RacingGameException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
