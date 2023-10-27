package racingcar.domain;

import java.util.List;

public class Play {
    public static void playGame(){

        List<String> carNames = UserInput.inputCarName();
        int gameCount = UserInput.inputGameCount();

        System.out.println(carNames);
        System.out.println(gameCount);

    }
}
