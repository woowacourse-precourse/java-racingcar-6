package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,ab,abc,abcd,abcde"})
    @DisplayName("입력받은 자동차의 이름이 정상적인 값만 들어오는 경우를 테스트.")
    void testCarNamesLength(String value) {
        //given
        RacingGameView racingGameView = new RacingGameView();
        //then
        assertDoesNotThrow(() -> racingGameView.validateCarNames(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,ab,abc,abcd,abcde,abcdef"})
    @DisplayName("입력받은 자동차의 이름 중 5글자를 초과하는 이름이 있으면 에러를 발생시킨다.")
    void testCarNamesLengthOver(String value) {
        //given
        RacingGameView racingGameView = new RacingGameView();
        //then
        assertThrows(IllegalArgumentException.class, () -> racingGameView.validateCarNames(value));
    }
}