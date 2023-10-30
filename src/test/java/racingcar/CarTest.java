package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차에 이름을 부여할 수 있다.")
    public void carNameApplyTest(){
        String givenName = "cho";
        Car car = Car.applyName(givenName);
        assertThat(givenName).isEqualTo(car.toString());
    }
}
