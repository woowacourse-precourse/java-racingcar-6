package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingCarServiceTest {
    private final RacingCarService racingCarService = new RacingCarService();
    @Test
    @DisplayName("경주에 나갈 자동차들 생성하기")
    public void 자동차들_생성하기() throws Exception {
        // given
        List<String> names = new ArrayList<>(List.of("pobi,woni,jun"));

        // when
        Cars cars = racingCarService.createCars(names);

        // then
        List<Car> carList = cars.getCars();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            Assertions.assertThat(car.getName()).isEqualTo(names.get(i));
        }
    }
}
