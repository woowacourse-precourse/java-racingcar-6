package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ExceptionMessage.INVALID_ATTEMPT;
import static racingcar.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
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
        assertThatThrownBy(() -> Game.create()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ATTEMPT);
    }

    @Test
    void Game_객체_생성_시_차_이름_글자_수_5_이상일_경우_예외_발생() {
        입력("love,hate,you,longCar\n1");
        assertThatThrownBy(() -> Game.create()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_NAME_LENGTH);
    }

    @Test
    void 알맞은_입력_값_입력_시_Game_객체_정상_생성() {
        입력("love,hate,you\n10");
        assertThatCode(() -> Game.create()).doesNotThrowAnyException();
    }

    private void 입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}