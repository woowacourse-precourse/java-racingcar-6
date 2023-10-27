package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class RefereeTest {

    @Test
    void 우승한_차량이_한_대() {
        // given
        int laps = 10;
        GameRule rule = new GameRule(5, 0, 9);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(rule, "Max"));
        cars.add(new Car(rule, "Lando"));
        cars.add(new Car(rule, "Lewis"));
        cars.add(new Car(rule, "Oscar"));
        cars.add(new Car(rule, "Alex"));
        cars.add(new Car(rule, "Sainz"));
        cars.add(new Car(rule, "Kevin"));
        MockedStatic<RandomNumberGenerator> mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        Referee referee = new Referee(cars);
        // when
        for (int i = 0; i < laps; i++) {
            for (int j = 0; j < cars.size(); j++) {
                mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                        .thenReturn(j);
                cars.get(j).moveForward();
            }
        }
        // then
        assertThat(referee.announceAllWinners()).isEqualTo("Kevin");
        mocked.close();
    }

    @Test
    void 우승한_차량이_두_대_이상() {
        // given
        int laps = 10;
        GameRule rule = new GameRule(5, 0, 9);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(rule, "Max"));
        cars.add(new Car(rule, "Lando"));
        cars.add(new Car(rule, "Lewis"));
        cars.add(new Car(rule, "Oscar"));
        cars.add(new Car(rule, "Alex"));
        cars.add(new Car(rule, "Sainz"));
        cars.add(new Car(rule, "Kevin"));
        MockedStatic<RandomNumberGenerator> mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        Referee referee = new Referee(cars);
        // when
        for (int i = 0; i < laps; i++) {
            for (int j = 0; j < cars.size(); j++) {
                mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                        .thenReturn(cars.get(j).getName().length());
                cars.get(j).moveForward();
            }
        }
        // then
        String winners = cars.stream()
                .filter(car -> car.getName().length() == 5)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        assertThat(referee.announceAllWinners()).isEqualTo(winners);
        mocked.close();
    }

    @Test
    void 모든_차량이_동일한_거리_이동() {
        // given
        int laps = 10;
        GameRule rule = new GameRule(5, 0, 9);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(rule, "Max"));
        cars.add(new Car(rule, "Lando"));
        cars.add(new Car(rule, "Lewis"));
        cars.add(new Car(rule, "Oscar"));
        cars.add(new Car(rule, "Alex"));
        cars.add(new Car(rule, "Sainz"));
        cars.add(new Car(rule, "Kevin"));
        MockedStatic<RandomNumberGenerator> mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                .thenReturn(cars.get(5).getName().length());
        Referee referee = new Referee(cars);
        // when
        for (int i = 0; i < laps; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).moveForward();
            }
        }
        // then
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        assertThat(referee.announceAllWinners()).isEqualTo(winners);
        mocked.close();
    }
}
