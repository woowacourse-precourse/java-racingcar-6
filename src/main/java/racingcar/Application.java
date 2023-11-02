package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;
import racingcar.model.RacingGame;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        RacingGame racingGame = new RacingGame(cars);

        System.out.println("시도할 회수는 몇회인가요?");
        String step = Console.readLine();
        int stepNum = InputException.exceptionCheckStep(step);
        racingGame.playGame(stepNum);
    }
}
