package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

class GameRoundTest {

    @Test
    @DisplayName("게임 회수 실행 값을 1보다 작은 값으로 입력한 경우 예외 발생")
    void 예외_처리_테스트_1() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameRound(-1, 0);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameRound(0, 0);
                });
    }

    @Test
    @DisplayName("게임 진행 회수 초기 값이 0이 아닌 경우 에외 발생")
    void 예외_처리_테스트_2() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameRound(3, -1);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameRound(3, 2);
                });
    }

    @Test
    void increaseCurrentRound() {
    }

    @Test
    void isLeftRound() {
    }
}