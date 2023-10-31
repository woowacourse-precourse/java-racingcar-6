package racingcar.util.channel;

import racingcar.Application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.NsTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

@DisplayName("시도 횟수 입력기 테스트")
class ReaderForTrialTest extends NsTest {
    private static final String VALID_RACING_CAR_NAMES_INPUT = "pobi, woni, jun";

    @DisplayName("빈 값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "\n", " ", "  ", "    "
    })
    void Is_Expected_Validation_About_Blank(String invalidTrialInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(
                        VALID_RACING_CAR_NAMES_INPUT,
                        invalidTrialInput)
                ).isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("한글/영어/특수기호를 포함하고 있는 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
        "ㄱㄴㄷ가나다", "abcABC", ".,/%$#^", "1234567890ㅑㅑ"
    })
    void Is_Expected_Validation_About_Not_Numeric(String invalidTrialInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(
                        VALID_RACING_CAR_NAMES_INPUT,
                        invalidTrialInput)
                ).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("0만 입력하거나 0으로 시작되는 잘못된 형식의 숫자를 입력 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "00700", "0", "00", "01234567890"
    })
    void Is_Expected_Validation_About_Invalid_Number(String invalidTrialInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(
                        VALID_RACING_CAR_NAMES_INPUT,
                        invalidTrialInput)
                ).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}