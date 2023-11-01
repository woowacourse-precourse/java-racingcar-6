package racingcar;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    RacingGame game = new RacingGame();

    @Test
    void 공백_입력_예외처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream("pobi,  woni,jun".getBytes()));
            game.inputCarsName();
        }, "공백 입력 예외가 발생하지 않았습니다");
    }

    @Test
    void 자동차_이름길이_예외처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream("pobi,looooooong".getBytes()));
            game.inputCarsName();
        }, "자동차 이름길이 예외가 발생하지 않았습니다");
    }

    @Test
    void 시도횟수_입력_예외처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream("-1".getBytes()));
            game.inputTryNum();
        }, "시도횟수 입력 예외가 발생하지 않았습니다");
    }

}