package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarManagerTest {

    @Test
    @DisplayName("자동차들의 이름에 중복이 있다면 에러를 반환한다.")
    public void validate_duplicate() {
        List<String> nameList = Arrays.asList("pobi", "pobi", "jun");
        List<Car> cars = nameList.stream().map(Car::createCar)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new CarManager(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들의 상태를 반환한다.")
    public void getCarStatus() {
        RaceRule raceRule = () -> true;

        List<String> nameList = Arrays.asList("pobi", "woni", "jun");
        List<Car> cars = nameList.stream().map(Car::createCar)
                .collect(Collectors.toList());

        CarManager carManager = new CarManager(cars);

        String status = carManager.moveCar(raceRule);

        assertThat(status).contains("pobi : -");
        assertThat(status).contains("woni : -");
        assertThat(status).contains("jun : -");
    }

    @Test
    @DisplayName("우승자를 반환한다.")
    public void getWinner() {
        RaceRule raceRule = () -> true;

        List<String> nameList = Arrays.asList("pobi", "woni", "jun");
        List<Car> cars = nameList.stream().map(Car::createCar)
                .collect(Collectors.toList());

        CarManager carManager = new CarManager(cars);

        carManager.moveCar(raceRule);
        String winner = carManager.getWinner();

        assertThat(winner).isEqualTo("pobi, woni, jun");
    }

}