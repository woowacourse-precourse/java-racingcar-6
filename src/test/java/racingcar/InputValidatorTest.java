package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Util;
import racingcar.validator.InputValidator;

public class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void initInputValidator() {
        Util util = new Util();
        inputValidator = new InputValidator(util);
    }

    @Test
    void 자동자_전체_이름_검증_null_예외처리() {
        assertThatThrownBy(() -> inputValidator.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름 목록이 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void 자동자_전체_이름_검증_빈_문자열_예외처리(String carNames) {
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름 목록이 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "aa,bb,", ",aa,bb", ",aa", "aa,,bb"})
    void 자동자_전체_이름_검증_부적절한_콤마_사용_예외처리(String carNames) {
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 ','사용입니다.");
    }

    @Test
    void 자동자_전체_이름_검증_이름중복_예외처리() {
        assertThatThrownBy(() -> inputValidator.validateCarNames("aa,aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 같은 자동차들이 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"홍길동,test,z플립", "aa,bb", "Ad,zxc,수훈"})
    void 자동자_전체_이름_검증_정상처리(String carNames) {
        assertThatCode(() -> inputValidator.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"홍길동", "asus", "Asus"})
    void 하나의_자동차_이름_검증_정상처리(String carName) {
        assertThatCode(() -> inputValidator.validateCarName(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\n"})
    void 하나의_자동차_이름_검증_빈_문자열_예외처리(String carName) {
        assertThatThrownBy(() -> inputValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("검증할 자동차 이름이 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"superMan", "666", " sdf", "sdf w", "가나다!", "@홍길동", "ㅎㄱㄷ"})
    void 하나의_자동차_이름_검증_예외처리(String carName) {
        assertThatThrownBy(() -> inputValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자의 한글, 영어 대소문자로 구성됩니다. " +
                        "한글은 자음, 모음만으로 구성할 수 없습니다.");
    }

    @Test
    void 시도_회수_검증_양수_정상처리() {
        assertThatCode(() -> inputValidator.validateIterationNumBer(13))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -12, -999})
    void 시도_회수_검증_0_예외처리(int iterationNumBer) {
        assertThatThrownBy(() -> inputValidator.validateIterationNumBer(iterationNumBer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 양수입니다.");
    }
}
