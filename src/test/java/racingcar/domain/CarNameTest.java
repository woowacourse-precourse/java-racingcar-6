package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @DisplayName("자동차 이름이 한글, 영어, 숫자만을 포함한 1자 이상 5자 이내면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "bcd", "한글", "1234", "abc한글"})
    void validateCarNamesSuccessTest(String name) {
        assertThatCode(() -> new CarName(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 한글, 영어, 숫자만을 포함한 5자 이내가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideValidateCarNamesFailTestArguments")
    void validateCarNamesFailTest(String name, String message) {
        assertThatCode(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    static Stream<Arguments> provideValidateCarNamesFailTestArguments() {
        return Stream.of(
                arguments("", "자동차 이름은 최소 1자 이상 최대 5자 이하만 가능합니다."),
                arguments("asddasadsaasds", "자동차 이름은 최소 1자 이상 최대 5자 이하만 가능합니다."),
                arguments("ㄹㅇ ", "자동차 이름은 한글, 영어, 숫자만 가능합니다."),
                arguments("ja va", "자동차 이름은 한글, 영어, 숫자만 가능합니다."),
                arguments(" java", "자동차 이름은 한글, 영어, 숫자만 가능합니다.")
        );
    }
}
