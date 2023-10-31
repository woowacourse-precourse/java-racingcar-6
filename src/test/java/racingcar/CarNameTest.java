package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest
    @DisplayName("[통과해야하는 케이스] CarName 생성 테스트")
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void successTest(String input) {
        CarName name = new CarName(input);
    }

    @ParameterizedTest
    @DisplayName("[실패야하는 케이스] CarName 생성 테스트")
    @ValueSource(strings = {"ChunJiwoo", ""})
    void failTest(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CarName(input)
        );
    }
}