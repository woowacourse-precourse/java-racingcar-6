package racingcar.domain;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;
import racingcar.exception.ErrorMessage;

class RacingTest {

    @Test
    void 차_리스트_null_경우_에러_반환() {
        assertThatThrownBy(() -> new Racing(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_CAR_LIST);
    }

    @Test
    void 차_리스트_비어있는_경우_에러_반환() {
        List<Car> carList = new ArrayList<>();
        assertThatThrownBy(() -> new Racing(carList))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_CAR_LIST);
    }

    @Test
    void 차_이동거리_반환() {
        List<Car> carList = getCarList();
        List<CarDto> carDtoList = List.of(
                new CarDto("car1",1),
                new CarDto("car2",0),
                new CarDto("car3",0));
        Racing racing = new Racing(carList);
        assertRandomNumberInRangeTest(
                () -> {
                    racing.start();
                    assertThat(racing.getAllCarDistances()).isEqualTo(carDtoList);
                },
                4,3,3
        );
    }

    @Test
    void 가장_이동거리_긴_차_반환() {
        List<Car> carList = getCarList();
        List<CarDto> carDtoList = List.of(new CarDto("car1",1));
        Racing racing = new Racing(carList);
        assertRandomNumberInRangeTest(
                () -> {
                    racing.start();
                    assertThat(racing.getCarWithLongestDistance()).isEqualTo(carDtoList);
                },
                4,3,3
        );
    }

    private static List<Car> getCarList() {
        return List.of(new Car("car1"),new Car("car2"),new Car("car3"));
    }

}