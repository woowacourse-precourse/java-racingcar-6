package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car = new Car("name");

    @Test
    void 랜덤숫자_생성기_테스트() {
        int randomNumber = car.createRandomNumber();
        assertThat(randomNumber).isLessThan(10);
        assertThat(randomNumber).isGreaterThan(-1);
    }

    private class Car {
        private String carName;
        private String distanceDriven = "";
        public Car(String carName) {
            this.carName = carName;
        }

        public int createRandomNumber() {
            return Randoms.pickNumberInRange(0,9);
        }
    }
}
