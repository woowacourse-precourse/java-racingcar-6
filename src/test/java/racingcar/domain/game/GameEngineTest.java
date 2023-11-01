package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarInfo;
import racingcar.dto.Car;

class GameEngineTest {
    CarInfo carInfo = CarInfo.getInstance();

    @DisplayName("승자를 찾을 수 있다.")
    @Test
    void findWinner() {
        //given
        GameEngine gameEngine = new GameEngine();
        carInfo.saveCarInfo(new Car("a", 1));
        carInfo.saveCarInfo(new Car("b", 2));
        carInfo.saveCarInfo(new Car("c", 3));
        carInfo.saveCarInfo(new Car("d", 3));

        //when
        List<Car> winners = gameEngine.findWinner();

        //then
        assertThat(winners)
                .extracting(Car::name)
                .containsExactlyInAnyOrder("c", "d");
    }
}