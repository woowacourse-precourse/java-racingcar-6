package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.util.ValidationUtils;

public class ValidationTest {

    @Test
    void validateCarName_이름이_5자를_넘을때_예외_발생() {
        String input = "제임스고슬링,귀도반로섬";
        assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_자동차_이름이_하나일_때_예외_발생() {
        String input = "빌게이츠";
        assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_이름이_빈_값일_때_예외_발생() {
        String input = "";
        assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_입력_길이가_10000자_이상일_때_예외_발생() {
        String input = "가".repeat(10001);
        assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateTrialCount_입력_값이_문자일_때_예외_발생() {
        String input = "가나";
        assertThatThrownBy(() -> ValidationUtils.validateTrialCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateTrialCount_입력_값이_빈_값일_때_예외_발생() {
        String input = " ";
        assertThatThrownBy(() -> ValidationUtils.validateTrialCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
