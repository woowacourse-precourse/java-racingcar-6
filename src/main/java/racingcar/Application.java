package racingcar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static racingcar.InputValidator.validateString;

import java.util.ArrayList;
import java.util.Arrays;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame();

        InputController inputController = new InputController();
        String carNamesInput = inputController.carNamePrompt();

        // 유저 인풋 값 받고 차 준비
        String[] carNames = carNamesInput.split(",");
        ArrayList<String> carNamesList = new ArrayList<>(Arrays.asList(carNames));
        Cars cars = new Cars(carNamesList);
        int rounds = Integer.parseInt(inputController.roundPrompt());

        // 게임 준비
        racingGame.prepareGame(cars);
        // 게임 시작
        racingGame.startGame(rounds);
    }
}
