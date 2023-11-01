package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @DisplayName("1~5자 내의 크기를 가진 이름 입력 시 Name 인스턴스를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"poby", "woni", "junnn", "n"})
    void validNameTest(String rightName) {
        Assertions.assertThatNoException().isThrownBy(() -> new Name(rightName));
    }

    @DisplayName("0자 이하 혹은 5자 초과의 이름 입력 시 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobypoby", "woniii", ""})
    void failNameLengthTest(String failName) {
        Assertions.assertThatThrownBy(() -> new Name(failName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
