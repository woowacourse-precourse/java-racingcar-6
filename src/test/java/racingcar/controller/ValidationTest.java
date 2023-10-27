package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationTest {
    private final Validation sample = new Validation();

    @ParameterizedTest
    @DisplayName("입력된 문자열의 처음이나 끝, 혹은 쉼표(,)들 사이에 자동차 이름이 누락되면 예외 발생(한 이름의 길이가 0)")
    @ValueSource(strings = {
            ",name1,name2", ",name1,name2,", "name1,name2,",
            "name1,,name2", ",,name1,name2", "name1,,,name2"
    })
    void checkNullNameInInput_test(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkNullNameInInput(input));
    }

    @Test
    @DisplayName("파싱된 문자열의 한 이름 토큰의 길이가 5를 초과하면 예외 발생, 길이가 5 이하면 정상 종료")
    void checkNameTokenLengthOver_test() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> sample.checkNameTokenLengthOver("sample"));
        assertThatCode(() -> sample.checkNameTokenLengthOver("name"))
               .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("현재 이름 토큰이 이미 Map에 저장된 key이면 예외 발생")
    @ValueSource(strings = {"name1", "name2", "name3"})
    void checkNameTokenDuplicated_exceptionTest(String inputToken) {
        Map<String, Integer> inputMap = Map.of("name1", 0, "name2", 0, "name3", 0);
        assertThatIllegalArgumentException().isThrownBy(() -> sample.checkNameTokenDuplicated(inputToken, inputMap));
    }
    @Test
    @DisplayName("현재 이름 토큰이 Map에 없는 새로운 key이면 정상 종료")
    void checkNameTokenDuplicated_normalTest() {
        Map<String, Integer> inputMap = Map.of("name1", 0, "name2", 0, "name3", 0);
        String inputToken = "name4";
        assertThatCode(() -> sample.checkNameTokenDuplicated(inputToken, inputMap)).doesNotThrowAnyException();
    }
}
