package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {


    @DisplayName("Car 객체 생성자 테스트")
    @Test
    void car() {
        //given
        Car car = new Car("pobi");

        //when
        String carName = car.getName();

        //then
        assertThat(carName).isEqualTo("pobi");

    }

    @DisplayName("Car 객체 위치 비교 함수 테스트")
    @Test
    void isLocationEqual() {
        //given
        Car car = new Car("pobi");
        car.move(10);

        //when
        int maxLocation = 10;
        boolean isEqual = car.isLocationEqual(maxLocation);

        //then
        assertThat(isEqual).isTrue();
    }

    @DisplayName("Car 이동 함수 테스트")
    @Test
    void move() {
        //given
        Car car = new Car("pobi");

        //when
        car.move(5);

        //then
        assertThat(car.getLocation()).isEqualTo(5);
    }

    @DisplayName("Car 객체 위치 값 문자열 반환 함수 테스트")
    @Test
    void getStringLocation() {
        //given
        Car car = new Car("pobi");
        car.move(5);

        //when
        String stringLocation = car.getStringLocation();

        //then
        assertThat(stringLocation).isEqualTo("-----");
    }

}
