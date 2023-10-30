package racingcar.domain;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;

class RacingTest {

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