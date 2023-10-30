package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarDistance;
import racingcar.vo.CarName;

class RefereeTest {

    private List<CarName> carNames;
    private Cars cars;
    private Referee referee;
    private RacingGame racingGame;

    @BeforeEach
    void init() {
        carNames = List.of(new CarName("Car1"), new CarName("Car2"));
        cars = new Cars(carNames);
        referee = new Referee();
        racingGame = new RacingGame(cars, referee);
    }

    @DisplayName("우승자를 결정해서 리스트 형태로 우승자들의 이름을 담는다.")
    @Test
    void decideWinner_test() throws Exception {
        // given
        List<Car> carList = cars.getCarList();
        Car car = carList.get(0);

        Field carDistance = Car.class.getDeclaredField("carDistance");
        carDistance.setAccessible(true);
        carDistance.set(car, new CarDistance(1));

        referee.decideWinner(carList);

        // when
        List<CarName> winnerNames = referee.getWinnerNames();

        // then
        assertTrue(!winnerNames.isEmpty());
        assertEquals(winnerNames.get(0).name(), "Car1");
    }
}
