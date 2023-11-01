package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름이 공백이라면 예외가 발생한다.")
    void nameNullTest(){
        assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5글자가 넘어가면 예외가 발생한다.")
    void nameMaxLengthTest(){
        assertThatThrownBy(() -> new Name("woowacourse"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}