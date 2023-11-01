package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

public class ValidatorTest {
    @DisplayName("자동차 이름 입력값이 쉼표로 구분되었는지 검사")
    @Test
    void 자동차_이름_쉼표_구분_테스트() {
        // given
        String case1 = "pobi.woni.jun";
        String case2 = "pobi,woni,jun";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateSeparatedByComma(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validator.validateSeparatedByComma(case2);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름의 길이가 5자 이하인지 검사")
    @Test
    void 자동차_이름_길이_테스트() {
        // given
        final String NAME_LENGTH_SIX = "minjun";
        final String NAME_LENGTH_FIVE = "minju";
        List<String> case1 = List.of("pobi", "woni", "jun", NAME_LENGTH_SIX);
        List<String> case2 = List.of("pobi", "woni", "jun", NAME_LENGTH_FIVE);

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateCarNameLength(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validator.validateCarNameLength(case2);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 중복되었는지 검사")
    @Test
    void 자동차_이름_중복_테스트() {
        // given
        final String DUPLICATE_POBI = "pobi";
        List<String> case1 = List.of("pobi", "woni", "jun", DUPLICATE_POBI);

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateDuplicateCarNames(case1);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수 입력값이 숫자인지 검사")
    @Test
    void 시도_횟수_숫자_테스트() {
        // given
        String case1 = "오";
        String case2 = "1이3";
        String case3 = "5";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateInputIsNumeric(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validator.validateInputIsNumeric(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validator.validateInputIsNumeric(case3);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수 입력값이 비어 있거나 빈 공백으로만 이루어져 있는지 검사")
    @Test
    void 시도_횟수_공백_테스트() {
        // given
        String case1 = "";
        String case2 = " ";
        String case3 = "   ";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateNonEmpty(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validator.validateNonEmpty(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validator.validateNonEmpty(case3);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수 입력값이 1 이상인지 검사")
    @Test
    void 시도_횟수_최소값_테스트() {
        // given
        final int ATTEMPT_NUMBER_ZERO = 0;
        final int MIN_ATTEMPT_NUMBER = 1;
        int case1 = ATTEMPT_NUMBER_ZERO;
        int case2 = MIN_ATTEMPT_NUMBER;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateAtLeastOne(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validator.validateAtLeastOne(case2);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).doesNotThrowAnyException();
    }
}
