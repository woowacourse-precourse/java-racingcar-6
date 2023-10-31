package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.game.car.Car;

class GameProgressTest {
    @Test
    @DisplayName("변환되는 진행상황 문자열의 형식을 확인한다.")
    void test_ConvertResultToStringSuccessful_NewLines() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 1);

        //when
        List<Car> cars = List.of(car1, car2);
        GameProgress gameProgress = GameProgress.of(cars);

        //then
        assertThat(gameProgress.convertResultToString()).isEqualTo(
                "car1 : ---" + System.lineSeparator() + "car2 : -"
        );
    }
}
