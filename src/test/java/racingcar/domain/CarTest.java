package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void moveOrStop_메서드_사용시_입력된_숫자에_맞게_거리가_증가하는지() {
        Car firstCar = new Car("first");
        Car sencondCar = new Car("second");
        Car thirdCar = new Car("third");
        int testNumThree = 3;
        int testNumFour = 4;
        int testNumFive = 5;

        firstCar.moveOrStop(testNumThree);
        sencondCar.moveOrStop(testNumFour);
        thirdCar.moveOrStop(testNumFive);

        assertThat(firstCar.getDistance()).isEqualTo(0);
        assertThat(sencondCar.getDistance()).isEqualTo(1);
        assertThat(thirdCar.getDistance()).isEqualTo(1);
    }
}