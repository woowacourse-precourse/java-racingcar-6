package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("현재 라운드가 총 라운드 보다 작은 경우 increaseCurrentRound()는 true를 반환")
    void increaseCurrentRound_현재_라운드_올라감_테스트() {
        // given
        GameRound gameRound = new GameRound(5, 0);

        // when
        Boolean result = gameRound.increaseCurrentRound();

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("현재 라운드가 총 라운드 보다 같은 경우 increaseCurrentRound()는 false를 반환")
    void increaseCurrentRound_현재_라운드_올라가지_않음_테스트() {
        // given
        GameRound gameRound = new GameRound(5, 0);
        while (gameRound.isLeftRound()) gameRound.increaseCurrentRound();

        // when
        Boolean result = gameRound.increaseCurrentRound();

        // then
        assertEquals(false, result);
    }


    @Test
    @DisplayName("현재 라운드가 총 라운드 보다 작은 경우 isLeftRound()는 true를 반환")
    void isLeftRound_남은_라운드_있음_테스트() {
        // given
        GameRound gameRound = new GameRound(5, 0);

        // when
        Boolean result = gameRound.isLeftRound();

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("현재 라운드가 총 라운드와 같은 경우 isLeftRound()는 false를 반환")
    void isLeftRound_남은_라운드_없음_테스트() {
        // given
        GameRound gameRound = new GameRound(5, 0);
        while (gameRound.isLeftRound()) gameRound.increaseCurrentRound(); // 남아 있는 모든 라운드 돌리기

        // when
        Boolean result = gameRound.isLeftRound();

        // then
        assertEquals(false, result);
    }
}