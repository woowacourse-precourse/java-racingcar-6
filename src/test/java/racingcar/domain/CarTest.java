package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차를 성공적으로 생성하는 테스트")
    public void createCar() {
        String name = "test";

        Car car = Car.createCar(name);

        assertThat(car.getCarStatus()).isEqualTo(name + " : ");
    }

    @Test
    @DisplayName("자동차의 상태를 문자열로 반환한다.")
    public void returnCarStatus() {
        String name = "test";

        Car car = Car.createCar(name);

        car.moveForward();

        assertThat(car.getCarStatus()).isEqualTo(name + " : -");
    }

    @Test
    @DisplayName("자동차 생성 시 아무 값을 입력하지 않을 경우 예외를 반환한다.")
    public void fail_createCar_input_not_blank() {
        String invalidName1 = "   ";
        String invalidName2 = "";

        assertThatThrownBy(() -> Car.createCar(invalidName1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Car.createCar(invalidName2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 생성 시 5자 이상을 입력할 경우 예외를 반환한다.")
    public void fail_createCar_input_over_length() {
        String name = "toLong";

        assertThatThrownBy(() -> Car.createCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 생성 시 이름이 같으면 같은 객체이다.")
    public void createCar_same_name_same_object() {
        String name = "test";
        String sameName = name;

        Car car = Car.createCar(name);
        Car sameCar = Car.createCar(sameName);

        assertThat(car).isEqualTo(sameCar);
    }

    @Test
    @DisplayName("자동차 이름이 같으면 같은 해시 코드를 갖는다.")
    public void createCar_same_name_same_hash() {
        String name = "test";
        Map<Car, Integer> carMap = new HashMap<>();

        carMap.put(Car.createCar(name), 1);

        assertThat(carMap.get(Car.createCar(name))).isEqualTo(1);
    }
}