package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.Cars;

class RacingStatusTest {
    RacingStatus racingStatus = new RacingStatus();
    Cars cars;
    Car car;

    @BeforeEach
    void setUp() {
        /**
         * 5대의 차량을 준비하고, 각각 (1, 3, 2, 3, 1)번 전진시킴
         */
        cars = new Cars(List.of(
                new Car("a", 1),
                new Car("b", 3),
                new Car("c", 2),
                new Car("d", 3),
                new Car("e", 1)
        ));

        /**
         * 한 대의 차량을 10번 전진시킴
         */
        car = new Car("sangd", 10);
    }

    @DisplayName("차량의 이름과 위치 정보를 이용하여, 현재 차량의 경주 상태를 정확히 출력하는지 확인합니다.")
    @Test
    void getProgressOfCar_IsReturnCorrectResult() {
        String expected = "sangd : ----------";

        assertThat(racingStatus.getProgressOfCar(car))
                .isEqualTo(expected);
    }

    @DisplayName("현재의 경주 상태를 정확히 출력하는지 확인합니다.")
    @Test
    void getRaceProgress_IsReturnCorrectResult() {
        String expected = """
                a : -
                b : ---
                c : --
                d : ---
                e : -
                """;

        assertThat(racingStatus.getRaceProgress(cars.carList()))
                .isEqualTo(expected);
    }

    @DisplayName("우승자 리스트를 받아 정확히 우승 메시지를 출력하는지 확인합니다.")
    @Test
    void getWinners_IsReturnCorrectResult() {
        String expected = "최종 우승자 : b, d";

        assertThat(racingStatus.getWinners(cars.findWinners()))
                .isEqualTo(expected);
    }
}