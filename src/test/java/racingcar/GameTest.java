package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.Game;
import racingcar.model.Car;
import racingcar.model.Cars;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game = new Game();

    @Test
    @DisplayName("전진 테스트")
    public void moveForwardByRandomNumberTest() {
        //given
        String carName = "test";
        Car car = new Car(carName);

        //when
        car.moveForward();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("1등 위치 값 구하기 테스트")
    public void getLeaderPositionTest() {
        //given
        Cars cars = new Cars(Arrays.asList(("1st,2nd").split(",")));

        //when
        cars.getCarList().stream().findFirst().get().moveForward();

        //then
        assertThat(game.getLeaderPosition(cars)).isEqualTo(1);
    }

    @Test
    @DisplayName("다중 1등 구하기 테스트")
    public void getMultipleWinnerTest() {
        //given
        Cars cars = new Cars(Arrays.asList(("1st,2nd").split(",")));

        //when
        cars.getCarList().stream().forEach(car -> car.moveForward());

        //then
        assertThat(game.getWinner(cars, game.getLeaderPosition(cars))).isEqualTo("1st, 2nd");
    }
}
