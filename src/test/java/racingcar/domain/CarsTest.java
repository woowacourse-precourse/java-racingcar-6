package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Utils;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class CarsTest {

    @DisplayName("입력값을 기반으로 자동차를 생성한다.")
    @Test
    void makeCars() {
        // given
        List<String> nameList = List.of("pobi", "lee", "kim");

        // when
        Cars cars = new Cars();
        cars.makeCars(nameList);
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList.size()).isEqualTo(3);
    }

    @DisplayName("getter 호출 시 깊은 복사로 반환한다.")
    @Test
    void getCars() {
        // given
        List<String> nameList = List.of("pobi", "lee", "kim");

        // when
        Cars cars = new Cars();
        cars.makeCars(nameList);
        List<Car> carList = cars.getCars();

        // then
        assertNotSame(cars.getCars(), carList);
    }

    @DisplayName("자동차가 랜덤 숫자에 따라 움직이거나 멈춘다.")
    @Test
    void moveCars() {
        // given
        List<String> nameList = List.of("pobi", "lee", "kim");
        List<Integer> resultDistance = List.of(1,1,0);
        Cars cars = new Cars();
        cars.makeCars(nameList);
        mockStatic(Utils.class);
        when(Utils.makeRandomNumber()).thenReturn(7,5, 2);

        // when
        cars.moveCars();
        List<Car> carList = cars.getCars();

        // then
        IntStream.range(0, carList.size())
                .forEach(i -> {
                    Car car = carList.get(i);
                    assertThat(car.getDistance()).isEqualTo(resultDistance.get(i));
                });
    }
}