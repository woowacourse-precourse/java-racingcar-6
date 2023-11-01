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

    @Test
    void 단독_우승한_자동차_리스트_정상_출력() {
        List<String> carList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        int size = carList.size();
        movingCount.initMovingCount(size);
        movingCount.addCount(0);
        movingCount.addCount(1);
        movingCount.addCount(1);
        movingCount.addCount(2);
        List<String> winnerList = new ArrayList<>(Arrays.asList("woni"));

        assertThat(winnerList).isEqualTo(racingGame.extractResult(carList, size));
    }
}
