package racingcar;

import racingcar.model.Car;
import racingcar.model.Game;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(readLine());

        System.out.println();
        Game racingGame = new Game(carNames, numberOfAttempts);
        racingGame.startGame();
        racingGame.printWinners();

    }
}
