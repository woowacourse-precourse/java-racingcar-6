package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private String input = "자동차1,자동차2,자동차3";

    @Test
    void 자동차_배열_생성() {
        Cars cars = new Cars();
        cars.generateCars(input);
        List<Car> carList = cars.getCars();
        List<String> carNameList = carList.stream()
                .map(car->car.getCarName())
                .toList();
        List<String> inputList = Arrays.stream(input.split(",")).toList();
        assertThat(carNameList).isEqualTo(inputList);
    }

    @Test
    public void 최댓값_3일때_3반환() {
        Cars cars = new Cars();
        cars.generateCars(input);
        for(int i=0; i<3; i++){
            cars.getCars().get(0).increaseProcess();
        }
        assertThat(cars.calculrateMaxProcess()).isEqualTo(3);
    }
}
