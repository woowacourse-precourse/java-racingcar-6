package racingcar.domain;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {
    final RacingGame racingGame = new RacingGame();

    @Test
    void 자동차_배열_리스트로_변환() {
        final String[] arr = {"pobi", "woni", "jun"};

        racingGame.carsArrayToList(arr);

        assertThat(racingGame.getCarsList())
                .containsExactly("pobi", "woni", "jun")
                .startsWith("pobi")
                .endsWith("jun");
    }

    @Test
    void 자동차_위치_초기화() {
        final String[] arr = {"pobi", "woni", "jun"};

        racingGame.carsArrayToList(arr);
        racingGame.setPositionList();

        assertThat(racingGame.getCarsPositionList())
                .containsExactly(0, 0, 0);
    }

    @Test
    void 자동차_전진_확인() {
        final String[] arr = {"pobi", "woni", "jun"};

        racingGame.carsArrayToList(arr);
        racingGame.setPositionList();
        racingGame.singleRaceAttempt(4, 9);

        assertThat(racingGame.getCarsPositionList())
                .containsExactly(1, 1, 1);
    }

    @Test
    void 자동차_멈춤_확인() {
        final String[] arr = {"pobi", "woni", "jun"};

        racingGame.carsArrayToList(arr);
        racingGame.setPositionList();
        racingGame.singleRaceAttempt(0, 3);

        assertThat(racingGame.getCarsPositionList())
                .containsExactly(0, 0, 0);
    }
}