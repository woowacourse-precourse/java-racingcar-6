package racingcar.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerCheckSystemTest {
    private WinnerCheckSystem winnerCheckSystem;
    @BeforeEach
    void before() {
        winnerCheckSystem = new WinnerCheckSystem();
    }
    @Test
    @DisplayName("실제로 우승하는지")
    void 실제로_우승하는지() throws Exception {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move();
        List<Car> cars = List.of(car1, car2);

        //when
        List<Car> winners = winnerCheckSystem.getWinners(cars);
        //then
        assertThat(winners).containsExactly(car1);
    }
    @Test
    @DisplayName("동시 우승을 카운팅 하는지")
    void 동시_우승을_카운팅_하는지() throws Exception {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.move();
        car2.move();
        List<Car> cars = List.of(car1, car2,car3);

        //when
        List<Car> winners = winnerCheckSystem.getWinners(cars);
        //then
        assertThat(winners).containsExactly(car1,car2);
        assertThat(winners).doesNotContain(car3);
    }
}