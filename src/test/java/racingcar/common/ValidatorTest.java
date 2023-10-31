package racingcar.common;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("자동차 이름 검증")
    @Nested
    class carNameTest {
        @DisplayName("빈 문자열 입력 시 예외 발생")
        @ParameterizedTest(name = "carName=\"{0}\"" )
        @ValueSource(strings = {" ", " ,", "pobi, ,jun"})
        public void emptyCarName(String carNames) {
            StringToListConverter converter = new StringToListConverter();
            List<String> carNameList = converter.convert(carNames);
            assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(carNameList))
                    .getMessage().equals("빈 문자열은 입력이 불가능합니다.");
        }

        @DisplayName("이름 입력 안할 시 예외 발생")
        @ParameterizedTest(name = "carName=\"{0}\"" )
        @ValueSource(strings = {"", ","})
        public void nullCarName(String carNames) {
            StringToListConverter converter = new StringToListConverter();
            List<String> carNameList = converter.convert(carNames);
            assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(carNameList))
                    .getMessage().equals("이름을 입력해주세요.");
        }
    }
}