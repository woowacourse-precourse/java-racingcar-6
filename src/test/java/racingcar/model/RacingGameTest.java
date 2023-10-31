package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("게임 생성")
    void of() {
        String names = "pobi,crong,honux";
        int tryNo = 5;
        RacingGame racingGame = RacingGame.of(names, tryNo);

        assertThat(racingGame).isEqualTo(RacingGame.of(names, tryNo));
    }

    @Test
    @DisplayName("이동 - 모두 한칸씩 이동")
    void race() {
        String names = "pobi,crong,honux";
        int tryNo = 5;
        RacingGame racingGame = RacingGame.of(names, tryNo);
        racingGame = racingGame.race(() -> 4);

        assertThat(racingGame).isEqualTo(RacingGame.ofWithCount(names, tryNo, 1));
    }

    @Test
    @DisplayName("게임 종료 - 안끝남")
    void isEndFalse() {
        String names = "pobi,crong,honux";
        int count = 5;
        RacingGame racingGame = RacingGame.of(names, count);

        assertThat(racingGame.isEnd()).isFalse();
    }

    @Test
    @DisplayName("게임 종료 - 끝남")
    void isEndTrue() {
        String names = "pobi,crong,honux";
        int tryNo = 0;
        RacingGame racingGame = RacingGame.of(names, tryNo);

        assertThat(racingGame.isEnd()).isTrue();
    }
}