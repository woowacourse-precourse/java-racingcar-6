package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;
    private MovingCount movingCount;

    @BeforeEach
    void setUp() {
        movingCount = new MovingCount();
        racingGame = new RacingGame(movingCount);
    }

    @Test
    void 랜덤값_추출해서_리스트에_정상_저장() {
        List<String> carList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        int size = carList.size();
        movingCount.initMovingCount(size);
        List<Integer> numberList = racingGame.extractRandomNumber(carList);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 3, 5));

        assertThat(numberList).hasSize(expectedList.size()).doesNotContainNull();
    }
}
