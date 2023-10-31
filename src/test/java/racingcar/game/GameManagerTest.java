package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class GameManagerTest {
    GameManager gameManager;
    static final String[] CAR_SAMPLES = {
            "john",
            "jenny",
            "doe"
    };

    @BeforeEach
    void init() {
        gameManager = new GameManager(CAR_SAMPLES);
    }

    @Test
    void testProceed_and_testGetCurrentCarStates() {
        int[] times = {
                1, 3, 2
        };

        setting(times);

        int idx = 0;
        Map<String, Integer> carStates = gameManager.getCurrentCarStates();
        for (String car : CAR_SAMPLES) {
            Assertions.assertThat(carStates.get(car)).isEqualTo(times[idx++]);
        }
    }

    @Test
    void testImmutabilityOfReturnedObjectOfGetCurrentCarStates() {
        int[] times = {
                1, 3, 2
        };

        setting(times);

        Map<String, Integer> carStates = gameManager.getCurrentCarStates();
        gameManager.proceed(CAR_SAMPLES[0]);
        Assertions.assertThat(gameManager.getCurrentCarStates().get(CAR_SAMPLES[0]))
                .isNotEqualTo(carStates.get(CAR_SAMPLES[0]));
    }

    private void setting(int[] times) {
        for (int i = 0; i < CAR_SAMPLES.length; i++) {
            proceed(times[i], CAR_SAMPLES[i]);
        }
    }

    private void proceed(int time, String car) {
        for (int j = 0; j < time; j++) {
            gameManager.proceed(car);
        }
    }

    @Test
    void testGetWinners_oneWinner() {
        int[] aheadTimes = {
                3, 1, 0
        };

        setting(aheadTimes);

        List<String> winners = gameManager.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.get(0)).isEqualTo(CAR_SAMPLES[0]);
    }

    @Test
    void testGetWinners_twoWinners() {
        int[] aheadTimes = {
                3, 3, 2
        };

        setting(aheadTimes);

        List<String> winners = gameManager.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners).contains(CAR_SAMPLES[0], CAR_SAMPLES[1]);
    }

    @Test
    void testGetWinners_noProceed() {
        int[] aheadTimes = {
                0, 0, 0
        };

        setting(aheadTimes);

        List<String> winners = gameManager.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(3);
        Assertions.assertThat(winners).contains(CAR_SAMPLES[0], CAR_SAMPLES[1], CAR_SAMPLES[2]);
    }

    @Test
    void testIsSuccessToProceed_randomness() {
        int tryTimes = 10000;
        boolean[] results = new boolean[tryTimes];
        for (int i = 0; i < tryTimes; i++) {
            results[i] = GameManager.isSuccessToProceed();
        }

        boolean firstValue = results[0];
        Assertions.assertThat(results).contains(!firstValue);
    }
}