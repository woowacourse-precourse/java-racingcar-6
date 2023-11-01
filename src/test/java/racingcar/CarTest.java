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

    @Test
    void 랜덤값_4_이상일_경우_전진(){
        Car car1 = new Car("aaa");
        Car car2 = new Car("bbb");

        car1.moveCar(4);
        car2.moveCar(3);

        Assertions.assertThat(car1.getScore()).isEqualTo(1);
        Assertions.assertThat(car2.getScore()).isEqualTo(0);

    }

}
