package racingcar;

import static racingcar.ExceptionMessage.INVALID_ATTEMPT;
import static racingcar.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class GameTest {

    @AfterEach
    private void 콘솔_닫기() {
        Console.close();
    }

    @Test
    void Game_객체_생성_시_시도_횟수_0_이하일_경우_예외_발생() {
        입력("love,hate,you\n-1");
        Assertions.assertThatThrownBy(() -> Game.create()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ATTEMPT);
    }

    @Test
    void Game_객체_생성_시_차_이름_글자_수_5_이상일_경우_예외_발생() {
        입력("love,hate,you,longCar\n1");
        Assertions.assertThatThrownBy(() -> Game.create()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_NAME_LENGTH);
    }

    private void 입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}