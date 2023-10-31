package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.car.UserInputCarName;
import racingcar.game.UserInputGameRound;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    @Test
    void 자동차_이름_5초과_입력시_예외_처리() {
        String inputCarName = "123456";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputCarName.processInput(inputCarName);
        });
    }

    @Test
    void 중복된_자동차_이름_입력시_예외_처리() {
        String inputCarName = "car1,car2,car1";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputCarName.processInput(inputCarName);
        });
    }

    @Test
    void 경주할_자동차가_0개_입력시_예외_처리() {
        String inputCarName = " ";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputCarName.processInput(inputCarName);
        });
    }

    @Test
    void 문자열_시도_횟수_입력시_예외_처리() {
        String gameRound = "abc";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }

    @Test
    void 음수_시도_횟수_입력시_예외_처리() {
        String gameRound = "-2";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }

    @Test
    void 공백_시도_횟수_입력시_예외_처리() {
        String gameRound = " ";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }

    @Test
    void 시도_횟수_0번_입력시_예외_처리() {
        String gameRound = "0";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }
}
