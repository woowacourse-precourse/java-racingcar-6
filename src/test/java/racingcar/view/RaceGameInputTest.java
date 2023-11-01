package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceGameInputTest {

    @Test
    @DisplayName("자동차 이름과 시도할 횟수를 입력하면 객체를 생성한다.")
    void 자동차_이름과_시도할_횟수를_입력하면_객체를_생성한다() {
        // given
        var carNamesInput = "pobi,woni,jun";
        var roundInput = "5";

        // when
        var raceGameInput = RaceGameInput.from(carNamesInput, roundInput);

        // then
        assertThat(raceGameInput).isInstanceOf(RaceGameInput.class);
    }

    @Test
    @DisplayName("입력값이 빈 문자열이면 예외를 반환한다.")
    void 입력값이_빈_문자열이면_예외를_반환한다() {
        // given
        var carNamesInput = "";

        // when & then
        assertThatThrownBy(() -> RaceGameInput.from(carNamesInput, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어있습니다.");
    }

    @Test
    @DisplayName("입력값이 쉼표로 시작하면 예외를 반환한다.")
    void 입력값이_쉼표로_시작하면_예외를_반환한다() {
        // given
        var carNamesInput = ",pobi,woni,jun";

        // when & then
        assertThatThrownBy(() -> RaceGameInput.from(carNamesInput, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 쉼표로 시작하거나 끝날 수 없습니다.");
    }

    @Test
    @DisplayName("입력값이 쉼표로 끝나면 예외를 반환한다.")
    void 입력값이_쉼표로_끝나면_예외를_반환한다() {
        // given
        var carNamesInput = "pobi,woni,jun,";

        // when & then
        assertThatThrownBy(() -> RaceGameInput.from(carNamesInput, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 쉼표로 시작하거나 끝날 수 없습니다.");
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아니면 예외를 반환한다.")
    void 시도할_횟수가_숫자가_아니면_예외를_반환한다() {
        // given
        var carNamesInput = "pobi,woni,jun";
        var roundInput = "one";

        // when & then
        assertThatThrownBy(() -> RaceGameInput.from(carNamesInput, roundInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }
}
