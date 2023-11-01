package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DisplayName("Car 클래스 테스트")
class CarTest {
    private final int INIT_NUMBER = 0;

    @Test
    @DisplayName("입력받은 이름이 5자 초과면 IllegalArgumentException을 발생시켜야 한다.")
    void init_name_exception_test() {
        String name = "javajjang";
        Assertions.assertThatThrownBy(() -> new Car(name, INIT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 이름이 1자 미만이면 IllegalArgumentException을 발생시켜야 한다.")
    void init_blank_name_exception_test() {
        String name = "";
        Assertions.assertThatThrownBy(() -> new Car(name, INIT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 받은 이름이 5글자 이하면 입력 받은 이름과 같은 이름의 Car 인스턴스가 생성되어야 한다.")
    void init_success_test() {
        String name = "java";
        Car car = new Car(name, INIT_NUMBER);
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("4이상의 값을 받은 car는 INIT_NUMBER + 1으로 초기화 된 Car의 position 값이 같아야한다.")
    void move_forward() {
        Car car = new Car("java", INIT_NUMBER);
        Car car2 = new Car("java2", INIT_NUMBER + 1);

        car.move(5);
        Assertions.assertThat(car.isSamePosition(car2)).isTrue();
    }

    @Test
    @DisplayName("4이하의 값을 받은 car는 INIT_NUMBER 으로 초기화 된 Car의 position 값이 같아야한다.")
    void move_stay() {
        Car car = new Car("java", INIT_NUMBER);
        Car car2 = new Car("java2", INIT_NUMBER);

        car.move(0);
        Assertions.assertThat(car.isSamePosition(car2)).isTrue();
    }

    @Test
    @DisplayName("position이 더 작은 차를 큰 차와 비교하면 양수가 나와야한다.")
    void compareTo() {
        Car car0 = new Car("java", INIT_NUMBER);
        Car car1 = new Car("java2", INIT_NUMBER + 1);

        Assertions.assertThat(car0.compareTo(car1) > 0).isTrue();
    }

    @Test
    @DisplayName("List<Car>는 position이 큰 순서대로 정렬되어야 한다. 즉, 정렬 후 List<Car>의 첫번째 요소는 car1과 position 값이 같아야한다.")
    void list_car_sort() {
        Car car0 = new Car("java", INIT_NUMBER);
        Car car1 = new Car("java2", INIT_NUMBER + 1);

        List<Car> cars = new ArrayList<>(List.of(car0, car1));
        Collections.sort(cars);

        Assertions.assertThat(cars.get(0).isSamePosition(car1)).isTrue();
    }
}