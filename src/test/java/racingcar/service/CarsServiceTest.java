package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

class CarsServiceTest {
    private final String[] carArray = {"벤츠", "아우디", "BMW", "페라리"};
    private Cars cars;

    private CarsService carsService;

    @BeforeEach
    void beforeEach() {
        cars = new Cars(carArray);
        carsService = new CarsService(cars);
    }

    @Test
    void 가장_멀리있는_자동차_위치_확인() {
        cars.getCar(0).addPosition();
        cars.getCar(0).addPosition();
        assertThat(carsService.getMaxPosition()).isEqualTo(2);

    }

    @Test
    void 우승_자동차_확인() {
        cars.getCar(0).addPosition();
        cars.getCar(1).addPosition();
        List<String> resultCarlist = new ArrayList<>(Arrays.asList("벤츠", "아우디"));
        int maxPosition = carsService.getMaxPosition();
        assertThat(carsService.getCarNamesAtPosition(maxPosition)).isEqualTo(resultCarlist);
    }
}