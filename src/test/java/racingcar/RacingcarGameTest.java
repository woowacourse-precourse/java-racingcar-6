package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarGameTest {

    RacingcarGame racingcarGame = new RacingcarGame();

    @Test
    void 아무것도_입력되지_않을_때() {
        final String carNamesWithComma = "";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백만_입력했을_때() {
        final String carNamesWithComma = " ";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 처음 이름이 공백일 때 예외 발생")
    @Test
    void 차_이름이_공백일_때_예외_발생2() {
        final String carNamesWithComma = " ,car2,car3";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 마지막 이름이 공백일 때 예외 발생")
    @Test
    void 차_이름이_공백일_때_예외_발생1() {
        final String carNamesWithComma = "car1,car2, ";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 처음 이름이 null일 때 예외 발생")
    @Test
    void 차_이름이_null일_때_예외_발생2() {
        final String carNamesWithComma = "car1,car2,";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 마지막 이름이 null일 때 예외 발생")
    @Test
    void 차_이름이_null일_때_예외_발생1() {
        final String carNamesWithComma = "car1,car2,";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름_좌우에_공백이_있을_때_통과() {
        final String carNamesWithComma = "car1 , car2, car3 ";
        final List<String> carNamesExpect = List.of("car1", "car2", "car3");
        final List<String> carNames = racingcarGame.getCarNames(carNamesWithComma);
        assertThat(carNames).isEqualTo(carNamesExpect);
    }

    @Test
    void 차_이름_내에_공백을_포함할_때_예외_발생() {
        final String carNamesWithComma = "car1,ca r2,car 3";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름이_5자_이상일_때_예외_발생() {
        final String carNamesWithComma = "car1,car12,car123";
        assertThatThrownBy(() -> racingcarGame.getCarNames(carNamesWithComma)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도회수가_숫자가_아닐_때_예외_발생() {
        final String tryCountString = "하나";
        assertThatThrownBy(() -> racingcarGame.getTryCount(tryCountString)).
                isInstanceOf(IllegalArgumentException.class);
    }

}
