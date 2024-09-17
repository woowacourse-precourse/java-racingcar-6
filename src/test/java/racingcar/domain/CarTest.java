package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 랜덤숫자가_4이상이면_distance증가_테스트(){
        Car car = new Car();
        int result = car.forward(5, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 랜덤숫자가_4이하면_distance변화없음_테스트(){
        Car car = new Car();
        int result = car.forward(3, 0);
        assertThat(result).isEqualTo(0);
    }
}
