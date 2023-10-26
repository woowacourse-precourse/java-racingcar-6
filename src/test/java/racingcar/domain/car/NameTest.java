package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {


    @DisplayName("이름이 5글자 이하라면 예외없이 Name이 성공적으로 생성됩니다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 이름_생성_테스트(String name) {
        Assertions.assertDoesNotThrow(() -> {
            new Name(name);
        });
    }

    @DisplayName("이름이 빈값이거나 5글자 초과라면 예외가 발생됩니다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "abcaaaaaa"})
    void 이름_생성_예외_테스트(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name(name);
        });
    }


}