package racingcar;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        HashMap<String, Integer> userResult = new CarNameInput().inputCarName();

        int attemptTimes = new AttemptsInput().inputAttempts();

        HashMap<String, Integer> userScore = new HashMap<>();

        for (int i = 0; i < attemptTimes; i++) {
            userScore = new RacingGame().playGame(userResult);
        }

    }
}
