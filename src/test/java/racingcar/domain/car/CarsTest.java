package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static racingcar.global.enums.ExceptionMessage.DUPLICATE_NAME_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 객체_생성_성공() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");

        List<Car> carList = List.of(car1, car2);

        //when
        Cars cars = new Cars(carList);

        //then
        assertNotNull(cars);
    }

    @Test
    void 중복_이름_객체_생성_실패() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("a");

        List<Car> carList = List.of(car1, car2);

        //when and then
        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NAME_MESSAGE.getMessage());

    }

    @Test
    void 컬렉션_사이즈_확인() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");

        List<Car> carList = List.of(car1, car2);
        int expectedSize = carList.size();
        Cars cars = new Cars(carList);

        //when
        int actualSize = cars.size();

        //then
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @Test
    void 컬렉션_불변_확인() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");

        // List.of()는 불변 리스트를 반환 하므로 원하는 테스트를 할 수 없음
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        Cars cars = new Cars(carList);

        //when
        List<Car> actualCarList = cars.getCar();

        //then
        assertThatThrownBy(() -> actualCarList.add(new Car("car3")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 자동차_포지션_기준_정렬_테스트() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        car2.moveForward();

        List<Car> carList = List.of(car1, car2);
        Cars cars = new Cars(carList);

        //when
        cars.sortingCarsOrderByPosition();

        //then
        assertThat(cars.getCar())
                .extracting(Car::getPosition)
                .containsExactly(1, 0);
    }

}