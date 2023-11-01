package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("자동차 이름이 영어 소문자로만 구성되지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"poby1", "123", "포비"})
    void carNameFormatTest(String failName) {
        Assertions.assertThatThrownBy(() -> new Car(new Name(failName)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
