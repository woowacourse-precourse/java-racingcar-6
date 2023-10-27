package racingcar.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @Test
    void 자동차_이름_검증_실패_길이제한() {
        final String INPUT = "yujin,wonyoung,rei";

        assertThatThrownBy(() -> inputValidator.checkNames(INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_검증_실패_빈이름() {
        final String INPUT = "yujin,love,,,rei";

        assertThatThrownBy(() -> inputValidator.checkNames(INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_검증_실패_잘못된구분점() {
        final String INPUT = ",yujin,love,rei";
        final String INPUT2 = "yujin,love,rei,";

        assertThatThrownBy(() -> inputValidator.checkNames(INPUT))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.checkNames(INPUT2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_검증_성공_다수() {
        String input = "yujin,rei,young,a";
        String[] result = new String[]{"yujin", "rei", "young", "a"};

        assertThat(inputValidator.checkNames(input))
                .containsExactly(result);
    }

    @Test
    void 자동차_이름_검증_성공_특수문자포함() {
        String input = "rei_,rei,aha!";
        String[] result = new String[]{"rei_", "rei", "aha!"};

        assertThat(inputValidator.checkNames(input))
                .containsExactly(result);
    }

    @Test
    void 자동차_이름_검증_성공_단일() {
        String input = "yujin";
        String result = "yujin";

        assertThat(inputValidator.checkNames(input))
                .containsExactly(result);
    }

    @Test
    void 이동_횟수_검증_실패_숫자가아님() {
        final String INPUT = "car";

        assertThatThrownBy(() -> inputValidator.checkCount(INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수_검증_실패_0입력() {
        final String INPUT = "0";

        assertThatThrownBy(() -> inputValidator.checkCount(INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수_검증_성공() {
        String input = "5";
        int result = Integer.parseInt(input);

        assertThat(inputValidator.checkCount(input))
                .isEqualTo(result);
    }

}