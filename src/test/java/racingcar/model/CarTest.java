package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    void testRandomNumberRange(){
        Car car = new Car();
        int num = car.getRandomNumber();
        assertThat(num).isBetween(0,9);
    }
    @Test
    void testAddNumber(){
        Car car = new Car();
        assertThat(car.addPlace()).isEqualTo(1);
    }
}