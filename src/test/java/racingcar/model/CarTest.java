package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    void 이름으로차만들기(){
        Car car = new Car("car1");
        assertThat(car.getName()).isEqualTo("car1");
    }
    @Test
    void 차전진시키기(){
        Car car = new Car("car1");
        for(int i=0; i<3; i++){
            car.forward();
        }
        assertThat(car.getPlace()).isBetween(0,3);
    }
}