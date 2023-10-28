package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.driver.Car;

class RefereeTest {

    @DisplayName("단독 우승: 심판은 최종 우승자를 발표한다.")
    @Test
    void announceRacingSoleWinner() {
        //given
        Car carA = new Car("A");
        carA.moveForward(5);
        Car carB = new Car("B");
        carB.moveForward(3);
        List<Car> cars = List.of(carA, carB);

        Referee referee = new Referee();

        //when
        String result = referee.announceRacingWinner(cars);

        //then
        assertThat(result).contains("최종 우승자 : " + carA.getName());
    }

    @DisplayName("공동 우승: 심판은 최종 우승자를 발표한다.")
    @Test
    void announceRacingCoWinner() {
        //given
        Car carA = new Car("A");
        Car carB = new Car("B");
        List<Car> cars = List.of(carA, carB);

        Referee referee = new Referee();

        //when
        String result = referee.announceRacingWinner(cars);

        //then
        assertThat(result).contains(carA.getName(), carB.getName());
    }

}
