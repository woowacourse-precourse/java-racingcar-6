package racingcar.car;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
public class CarTest {
    Car car = new Car("abcd",0);
    @Test
    void 이하_숫자_체크(){
        int underFour=3;
        assertThat(car.randomNumCheck(underFour)).isEqualTo(false);
    }
    @Test
    void 이상_숫자_체크(){
        int overFour=4;
        assertThat(car.randomNumCheck(overFour)).isEqualTo(true);
    }

}
