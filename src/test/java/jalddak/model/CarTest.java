package jalddak.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {
    @Test
    void move() {
        Car car = new Car("HJ");
        int before = car.getDistance();
        int randomNum = Randoms.pickNumberInRange(0, 9);
        car.move(randomNum);
        int after = car.getDistance();
        System.out.println("before = " + before + ", after = " + after + ", randomNum = " + randomNum);
        if (randomNum >= 4) {
            assertThat(after).isEqualTo(before + 1);
        } else {
            assertThat(after).isEqualTo(before);
        }
    }
}
