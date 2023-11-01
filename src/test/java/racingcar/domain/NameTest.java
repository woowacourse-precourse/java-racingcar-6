package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("자동차 이름이 5글자 이하이면 성공")
    void When_CarNameIsLessThan5_Expect_Success() {
        // when
        Name name = new Name("jason");

        // then
        Assertions.assertThat(name).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과이면 실패")
    void When_CarNameIsLongerThan5_Expect_Fail() {
        // then
        Assertions.assertThatThrownBy(() -> new Name("jasonn"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
