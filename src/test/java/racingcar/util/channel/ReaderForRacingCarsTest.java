package racingcar.util.channel;

import racingcar.Application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("시도 횟수 입력기 테스트")
class ReaderForRacingCarsTest extends NsTest {

    @DisplayName("빈 값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "\n", " ", "  ", "    "
    })
    void Is_Expected_Validation_About_Blank(String invalidTrialInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(invalidTrialInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("유효한 구분자가 아닌 기호를 쓰는 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "pobi, woni. jun", "pobi/woni/jun", "pobi & woni & jun", "pobi + woni - jun", "PO_, #ㅅ#, @ㅇ@"
    })
    void Is_Expected_Validation_About_Invalid_Separator(String invalidTrialInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(invalidTrialInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("잘못된 이름 형식을 가진 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "  ,  ,  ", "  , woni, jun", ""
    })
    void Is_Expected_Validation_About_Invalid_Name(String invalidTrialInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(invalidTrialInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}