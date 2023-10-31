package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 무작위_값이_4_이상이면_전진() {
        //given
        Car car = new Car("name") {
            @Override
            protected int generateRandomNumber() {
                return 4;
            }
        };
        int previousDistance = car.getDistance().length();

        //when
        car.moveOnRandomChance();

        //then
        int newDistance = car.getDistance().length();
        assertThat(newDistance).isEqualTo(previousDistance + 1);
    }

    @Test
    void 무작위_값이_4_미만이면_멈춤() {
        //given
        Car car = new Car("name") {
            @Override
            protected int generateRandomNumber() {
                return 3;
            }
        };
        int previousDistance = car.getDistance().length();

        //when
        car.moveOnRandomChance();

        //then
        int newDistance = car.getDistance().length();
        assertThat(newDistance).isEqualTo(previousDistance);
    }
}