package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.StepCount;
import racingcar.view.UserInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = new Cars(UserInput.userInputToStringList(Console.readLine()));
        System.out.println("시도할 회수는 몇회인가요?");
        StepCount stepCount = new StepCount(UserInput.userInputToInt(Console.readLine()));
        Game game = new Game(cars, stepCount);

        game.playGame();
    }
}