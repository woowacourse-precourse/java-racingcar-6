package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    public static void main(String[] args) {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        RacingGame racingGame = new RacingGame(carNames);
        racingGame.start(new TryNumber(5));
        racingGame.finish();
    }
}

