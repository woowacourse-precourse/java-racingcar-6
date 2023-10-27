package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameTest {

    @Test
    public void 게임_횟수입력_성공() {
        String carNames = "pobi,woni,jun";
        String attempts = "5";

        // 생성자 호출 시 예외가 발생하지 않는다면 성공
        Game game = new Game(carNames, attempts);

        assertThat(game.getAttempts()).isEqualTo(5);
    }

    @Test
    public void 게임_횟수입력_실패() {
        String carNames = "pobi,woni,jun";
        String attemptsString = "five";  // 숫자가 아닌 문자열
        String attemptsNegative = "-3";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Game(carNames, attemptsString))
                .withMessage("시도 횟수는 숫자로 입력되어야 합니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Game(carNames, attemptsNegative))
                .withMessage("시도 횟수는 양수여야 합니다.");
    }

}