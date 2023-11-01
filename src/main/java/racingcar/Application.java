package racingcar;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> carNameAndMovementCountMap = UserInput.inputCarNames();
        int numberOfRounds = UserInput.inputNumberOfRounds();

        RacingCarGame.executeAllRounds(carNameAndMovementCountMap, numberOfRounds);
        RacingCarGame.selectFinalWinner(carNameAndMovementCountMap);
    }
}