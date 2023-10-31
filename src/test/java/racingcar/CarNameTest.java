package racingcar;

import racingcar.model.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void 자동차_이름_생성() {
        CarName name = new CarName("mycar");
        Assertions.assertThat(name).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("이름 1글자 미만 입력 테스트")
    void 자동차_이름_1글자_미만_입력(String string) {
        Assertions.assertThatThrownBy(() -> new CarName(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcedf", "abcdefg"})
    @DisplayName("이름 5글자 초과 입력 테스트")
    void 자동차_이름_5글자_초과_입력(String string) {
        Assertions.assertThatThrownBy(() -> new CarName(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "ab c"})
    @DisplayName("이름 안 공백 입력 테스트")
    void 자동차_이름_공백_입력(String string) {
        Assertions.assertThatThrownBy(() -> new CarName(string))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
