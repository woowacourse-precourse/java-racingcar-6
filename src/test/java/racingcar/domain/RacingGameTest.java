package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"), 5);
    }

    @Test
    void 자동차_생성_기능_확인() {
        racingGame.initializeCars(Arrays.asList("pobi", "woni", "jun"));
        assertThat(racingGame.getCars().get(0)).isInstanceOf(Car.class);
    }

    @Test
    void 자동차_전진_기능_확인() {
        racingGame.getCars().get(0).moveForward();
        assertThat(racingGame.getCars().get(0).getForwardCount()).isEqualTo(1);
    }

    @Test
    void 공동_우승자_선정_기능_확인() {
        racingGame.getCars().get(0).moveForward();
        racingGame.getCars().get(1).moveForward();
        assertThat(racingGame.getWinners()).isEqualTo(List.of("car1", "car2"));
    }

    @Test
    void 단일_우승자_선정_기능_확인() {
        racingGame.getCars().get(0).moveForward();
        assertThat(racingGame.getWinners()).isEqualTo(List.of("car1"));
    }
}