package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RacingCarTest {

    @DisplayName("자동차 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    public void validateCarNameLengthOverflow(){
        assertThatThrownBy(()-> {
            new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
