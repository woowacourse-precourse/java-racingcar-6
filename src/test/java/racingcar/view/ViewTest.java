package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;
import static racingcar.global.exception.ErrorMessage.BLANK_INPUT_ERROR;
import static racingcar.global.exception.ErrorMessage.INVALID_COUNT_FORMAT;
import static racingcar.global.exception.ErrorMessage.INVALID_COUNT_RANGE;
import static racingcar.global.exception.ErrorMessage.INVALID_DELIMITER_ERROR;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class ViewTest {
    private static final String CORRECT_USER_INPUT = "pobi,woni";
    private static final String CORRECT_COUNT_INPUT = "5";

    private static MockedStatic<Console> console;

    @BeforeAll
    public static void setUp() {
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void tearDown() {
        console.close();
    }

    @Test
    void 자동차들의_이름을_입력받고_정상적으로_반환한다() {
        // given
        given(Console.readLine()).willReturn(CORRECT_USER_INPUT);

        // when
        String actual = View.requestCarNames();

        // then
        assertThat(actual).isEqualTo(CORRECT_USER_INPUT);
    }

    @Test
    void 총_전진_횟수를_입력받고_정상적으로_반환한다() {
        // given
        given(Console.readLine()).willReturn(CORRECT_COUNT_INPUT);

        // when
        String actual = View.requestCount();

        // then
        assertThat(actual).isEqualTo(CORRECT_COUNT_INPUT);
    }

    @Test
    void 빈_문자열이_입력되면_예외를_반환한다() {
        // given
        given(Console.readLine()).willReturn("");

        // when & then
        try {
            View.requestCarNames();
        } catch (IllegalArgumentException e) {
            assertThat(BLANK_INPUT_ERROR.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            View.requestCarNames();
        });
    }

    @Test
    void 문자열의_앞에_구분자를_붙여_예외를_반환한다() {
        // given
        given(Console.readLine()).willReturn(",poby,woni");

        // when & then
        try {
            View.requestCarNames();
        } catch (IllegalArgumentException e) {
            assertThat(INVALID_DELIMITER_ERROR.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            View.requestCarNames();
        });
    }

    @Test
    void 문자열의_뒤에_구분자를_붙여_예외를_반환한다() {
        // given
        given(Console.readLine()).willReturn("poby,woni,");

        // when & then
        try {
            View.requestCarNames();
        } catch (IllegalArgumentException e) {
            assertThat(INVALID_DELIMITER_ERROR.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            View.requestCarNames();
        });
    }

    @Test
    void 연속된_구분자가_포함되어_예외를_반환한다() {
        // given
        given(Console.readLine()).willReturn("poby,,woni");

        // when & then
        try {
            View.requestCarNames();
        } catch (IllegalArgumentException e) {
            assertThat(INVALID_DELIMITER_ERROR.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            View.requestCarNames();
        });
    }

    @Test
    void 숫자가_아닌_문자를_입력하여_예외를_반환한다() {
        // given
        given(Console.readLine()).willReturn("a");

        // when & then
        try {
            View.requestCount();
        } catch (IllegalArgumentException e) {
            assertThat(INVALID_COUNT_FORMAT.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            View.requestCount();
        });
    }

    @Test
    void 최소_전진_횟수보다_작게_입력하여_예외를_반환한다() {
        // given
        given(Console.readLine()).willReturn("0");

        // when & then
        try {
            View.requestCount();
        } catch (IllegalArgumentException e) {
            assertThat(INVALID_COUNT_RANGE.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            View.requestCount();
        });
    }
}
