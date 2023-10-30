package racingcar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static racingcar.InputValidator.validateCarName;

import java.util.ArrayList;
import java.util.Arrays;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame();

        // TODO: 프로그램 구현
        System.out.println("실행 잘 되나요??");

        RacingController racingController = new RacingController();
        String carNamesInput = racingController.carNamePrompt();

        String[] carNames = carNamesInput.split(",");

        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarName(carName);
            cars.add(new Car(carName));
        }
        int rounds = Integer.parseInt(racingController.roundPrompt());
        // 게임 준비
        racingGame.prepareGame(new ArrayList<>(cars));
        // 게임 시작
        racingGame.startGame(rounds);

        // 최종 우승자 확인
        String winner = racingGame.printGameWinner();

        System.out.println("winner = " + winner);

    }
}
