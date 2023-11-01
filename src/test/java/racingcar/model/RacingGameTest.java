package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

public class RacingGameTest {

    private static final int NUM_LOWER_THAN_FOUR = 3;
    private static final int NUM_FOUR = 4;
    private static final int NUM_HIGHER_THAN_FOUR = 5;
    private RacingGame racingGame;
    private Cars cars;
    private int raceCount;

    @BeforeEach
    void setUp() {
        cars = Cars.from(List.of("포비"));
        raceCount = 5;
        racingGame = RacingGame.init(cars, raceCount);
    }

    @Test
    void playGame_메서드_사용시_랜덤한_값이_4_미만인_경우_자동차_정지() {
        racingGame.playGame(new NumberGenerator(NUM_LOWER_THAN_FOUR, NUM_LOWER_THAN_FOUR));

        assertEquals(racingGame.getCarList().get(0).getPosition(), 0);
    }

    @Test
    void playGame_메서드_사용시_랜덤한_값이_4_이상인_경우_자동차_전진() {
        racingGame.playGame(new NumberGenerator(NUM_FOUR, NUM_FOUR));
        racingGame.playGame(new NumberGenerator(NUM_HIGHER_THAN_FOUR, NUM_HIGHER_THAN_FOUR));

        assertEquals(racingGame.getCarList().get(0).getPosition(), 2);
    }
}
