package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    @Test
    void 자동차_이름_가져오기(){
        Car car = new Car("jiixon");
        String result = car.getName();
        Assertions.assertThat(result).isEqualTo("jiixon");
    }

}
