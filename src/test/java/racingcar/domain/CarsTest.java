package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static racingcar.enums.Constant.MAX_NAME_LENGTH;
import static racingcar.enums.ExceptionMessage.EXCEED_MAX_LENGTH_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.TestUtils;

class CarsTest {

    @Test
    void 객체_생성_성공() {
        //given
        int length = MAX_NAME_LENGTH.getConstant();
        String name = TestUtils.generateName(length);
        Car car1 = new Car(name);
        Car car2 = new Car(name);
        List<Car> carList = List.of(car1, car2);

        //when
        Cars cars = new Cars(carList);

        //then
        assertNotNull(cars);
    }

    @Test
    void 객체_생성_실패() {
        //given
        int length = MAX_NAME_LENGTH.getConstant() + 1;
        String name = TestUtils.generateName(length);
        Car car1 = new Car("car1");
        Car car2 = new Car(name);
        List<Car> carList = List.of(car1, car2);

        //when and then
        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_MAX_LENGTH_MESSAGE.getMessage());
    }

    @Test
    void 컬렉션_사이즈_확인() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
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
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

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
}