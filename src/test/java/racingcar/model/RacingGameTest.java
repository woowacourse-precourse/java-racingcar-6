package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.RacingGameValidator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;
    private MovingCount movingCount;
    private OutputView outputView;
    private RacingGameValidator racingGameValidator;

    @BeforeEach
    void setUp() {
        movingCount = new MovingCount();
        outputView = new OutputView();
        racingGameValidator = new RacingGameValidator();
        racingGame = new RacingGame(movingCount, outputView, racingGameValidator);
        movingCount.initMovingCount(3);
    }

    @Test
    void 랜덤값_추출해서_리스트에_정상_저장() {
        List<String> carList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        List<Integer> numberList = racingGame.extractRandomNumber(carList);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 3, 5));

        assertThat(numberList).hasSize(expectedList.size()).doesNotContainNull();
    }

    @Test
    void 단독_우승한_자동차_리스트_정상_리턴() {
        List<String> carList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        int size = carList.size();
        movingCount.addCount(0);
        movingCount.addCount(1);
        movingCount.addCount(1);
        movingCount.addCount(2);
        List<String> winnerList = new ArrayList<>(Arrays.asList("woni"));

        assertThat(winnerList).isEqualTo(racingGame.extractResult(carList, size));
    }

    @Test
    void 공동_우승한_자동차_리스트_정상_리턴() {
        List<String> carList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        int size = carList.size();
        movingCount.addCount(0);
        movingCount.addCount(1);
        movingCount.addCount(1);
        movingCount.addCount(2);
        movingCount.addCount(2);
        List<String> winnerList = new ArrayList<>(Arrays.asList("woni", "jun"));

        assertThat(winnerList).isEqualTo(racingGame.extractResult(carList, size));
    }

    @Test
    void 자동차가_전진하는_경우() {
        int target = 4;
        int index = 0;
        int count = movingCount.getEachMovingCount(index);

        assertThat(count + 1).isEqualTo(racingGame.evaluateMoving(target, count, index));
    }

    @Test
    void 자동차가_전진하지_않는_경우() {
        int target = 2;
        int index = 0;
        int count = movingCount.getEachMovingCount(index);

        assertThat(count).isEqualTo(racingGame.evaluateMoving(target, count, index));
    }
}
