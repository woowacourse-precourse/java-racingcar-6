package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생한다.")
    @Test
    void nameLengthOver() {
        assertThatThrownBy(()->new Car("pobi,javajigi,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하로 입력해 주세요.");
    }
    @DisplayName("자동차 이름이 중복되면 예외를 발생한다.")
    @Test
    void duplicateName() {
        assertThatThrownBy(() -> new Car("pobi,pobi,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 입력한 자동차 이름 입니다.");
    }
}