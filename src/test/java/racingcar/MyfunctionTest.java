package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.object.Car;
import racingcar.object.Host;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MyfunctionTest {


    private Host host;

    @BeforeEach
    void 초기화() {
        host = new Host();
    }

    @Test
    @DisplayName("자동차 생성 확인")
    void 자동차_인풋테스트() {
        Car helloCar = new Car("hello", "");
        Car worldCar = new Car("world", "");
        host.setCarList(Arrays.asList(helloCar, worldCar));
        List<Car> carList = host.getCarList();
        assertThat(carList).isNotNull();
        assertThat(carList.size()).isEqualTo(2);
        assertThat(carList).contains(helloCar, worldCar);
    }

    @Test
    @DisplayName("자동차 생성실패 확인")
    void 자동차_인풋실패테스트() {
        Car helloCar = new Car("hellovv", "");
        Car worldCar = new Car("worldv", "");
        host.setCarList(Arrays.asList(helloCar, worldCar));
        List<Car> carList = host.getCarList();
        assertThatThrownBy(() -> carList.forEach(car -> {
            if (car.getName().length() > 5) throw new IllegalArgumentException("자동차 이름이 5이하가 아닙니다.");
        })).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름이 5이하가 아닙니다.");
    }

    @Test
    @DisplayName("경주 결과 확인")
    void 자동차_경주결과() {
        Car pobiCar = new Car("pobi", "-");
        Car woniCar = new Car("woni", "");
        host.setCarList(Arrays.asList(pobiCar, woniCar));
        host.setAttemptCount(0);
        host.carRacingResults();
        String racingResult = host.getRacingResult();
        assertThat(racingResult).contains("pobi");
    }


}
