package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private RacingGame racingGame;
    private String[] carsNameList = {"pobi", "woni", "jun"};

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void 자동차_배열_리스트로_변환() {
        racingGame.carsArrayToList(carsNameList);

        assertThat(racingGame.getCarsList())
                .containsExactly("pobi", "woni", "jun")
                .startsWith("pobi")
                .endsWith("jun");
    }

    @Test
    void 자동차_위치_초기화() {
        racingGame.carsArrayToList(carsNameList);
        racingGame.setPositionList();

        assertThat(racingGame.getCarsPositionList())
                .containsExactly(0, 0, 0);
    }

    @Test
    void 자동차_전진_확인() {
        racingGame.carsArrayToList(carsNameList);
        racingGame.setPositionList();
        racingGame.singleRaceAttempt(4, 9); // 무조건 한 번씩 전진해야 함.

        assertThat(racingGame.getCarsPositionList())
                .containsExactly(1, 1, 1);
    }

    @Test
    void 자동차_멈춤_확인() {
        racingGame.carsArrayToList(carsNameList);
        racingGame.setPositionList();
        racingGame.singleRaceAttempt(0, 3); // 무조건 정지해 있어야 함.

        assertThat(racingGame.getCarsPositionList())
                .containsExactly(0, 0, 0);
    }
}