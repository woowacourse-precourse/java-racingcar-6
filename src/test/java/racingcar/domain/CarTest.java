package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest{

    @Test
    @DisplayName("자동차 이름이 5보다 길면 예외를 던진다.")
    void 자동차_이름_길이_예외_처리(){
        assertThatThrownBy(()-> new Car("looooong")).isInstanceOf(IllegalArgumentException.class);
    }
}
