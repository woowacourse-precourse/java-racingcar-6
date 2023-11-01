package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;
import racingcar.View.SystemIn;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest extends SystemIn {
    public static RacingGame racingGame;
    @BeforeAll
    public static void initialize(){
        racingGame = new RacingGame();
    }
    @AfterEach
    public void consoleClear() {
        Console.close();
    }

    @Test
    @DisplayName("중복된 이름의 자동차 설정 시")
    void input() {
        systemIn("a,a,c");

        assertThatThrownBy(() -> racingGame.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 동일한 이름의 자동차 추가할 시");
    }

    @Test
    @DisplayName("playTime의 음수 값 입력 시")
    void minusSignPlayTimeRun() {
        systemIn("-10");

        assertThatThrownBy(() -> racingGame.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: playTime에 양수 아닌 값 입력 시");
    }

    @Test
    @DisplayName("playTime의 정수 아닌 값 입력 시")
    void notIntegerPlayTimeRun2() {
        systemIn("aaa");

        assertThatThrownBy(() -> racingGame.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: playTime에 양수 아닌 값 입력 시");
    }
}