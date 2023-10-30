package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class InputValidatorTest {

    @Test
    void 자동자_전체_이름_검증_null_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름 목록이 없습니다.");
    }

    @Test
    void 자동자_전체_이름_검증_빈_문자열_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름 목록이 없습니다.");
    }

    @Test
    void 자동자_전체_이름_검증_공백_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름 목록이 없습니다.");
    }

    @Test
    void 자동자_전체_이름_검증_개행_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름 목록이 없습니다.");
    }

    @Test
    void 자동자_전체_이름_검증_부적절한_콤마_사용1_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 ','사용입니다.");
    }

    @Test
    void 자동자_전체_이름_검증_부적절한_콤마_사용2_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("aa,bb,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 ','사용입니다.");
    }

    @Test
    void 자동자_전체_이름_검증_부적절한_콤마_사용3_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(",aa,bb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 ','사용입니다.");
    }

    @Test
    void 자동자_전체_이름_검증_부적절한_콤마_사용4_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(",aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 ','사용입니다.");
    }

    @Test
    void 자동자_전체_이름_검증_부적절한_콤마_사용5_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("aa,,bb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 ','사용입니다.");
    }

    @Test
    void 자동자_전체_이름_검증_이름중복_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("aa,aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 같은 자동차들이 있습니다.");
    }

    @Test
    void 자동자_전체_이름_검증_정상처리() {
        assertThatCode(() -> InputValidator.validateCarNames("홍길동,test,a맨"))
                .doesNotThrowAnyException();
    }

    @Test
    void 하나의_자동차_이름_검증_한글_정상처리() {
        assertThatCode(() -> InputValidator.validateCarName("홍길동"))
                .doesNotThrowAnyException();
    }

    @Test
    void 하나의_자동차_이름_검증_영어_정상처리() {
        assertThatCode(() -> InputValidator.validateCarName("Asus"))
                .doesNotThrowAnyException();
    }

    @Test
    void 하나의_자동차_이름_검증_빈_문자열_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름이 없습니다.");
    }

    @Test
    void 하나의_자동차_이름_검증_개행_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarName("\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름이 없습니다.");
    }

    @Test
    void 하나의_자동차_이름_검증_5자_초과_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarName("superMan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자의 한글, 영어 대소문자로 구성됩니다. " +
                        "한글은 자음, 모음만으로 구성할 수 없습니다.");
    }

    @Test
    void 하나의_자동차_이름_검증_숫자_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateCarName("666"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자의 한글, 영어 대소문자로 구성됩니다. " +
                        "한글은 자음, 모음만으로 구성할 수 없습니다.");
    }

    @Test
    void 시도_회수_검증_양수_정상처리() {
        assertThatCode(() -> InputValidator.validateIterationNumBer(13))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_검증_0_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateIterationNumBer(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 양수입니다.");
    }

    @Test
    void 시도_회수_검증_음수_예외처리() {
        assertThatThrownBy(() -> InputValidator.validateIterationNumBer(-12))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 양수입니다.");
    }
}
