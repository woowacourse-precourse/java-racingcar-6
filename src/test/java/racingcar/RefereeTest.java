package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class RefereeTest {

    private static GameRule rule;
    private Referee referee;
    private List<Car> cars;
    private static int laps;
    private static MockedStatic<RandomNumberGenerator> mocked;

    @BeforeEach
    private void setCarsAndReferee() {
        cars = new ArrayList<>();
        cars.add(new Car(rule, "Max"));
        cars.add(new Car(rule, "Lando"));
        cars.add(new Car(rule, "Lewis"));
        cars.add(new Car(rule, "Oscar"));
        cars.add(new Car(rule, "Alex"));
        cars.add(new Car(rule, "Sainz"));
        cars.add(new Car(rule, "Kevin"));
        referee = new Referee(cars);
    }

    @BeforeAll
    private static void init() {
        rule = new GameRule(5, 0, 9);
        laps = 10;
        mocked = Mockito.mockStatic(RandomNumberGenerator.class);
    }

    @AfterAll
    private static void clean() {
        mocked.close();
    }


    /**
     * 매 lap마다 각 자동차는 자신의 index만큼 앞으로 전진한다.
     * 인덱스가 4 이상인 자동차만 앞으로 전진하게 되고 인덱스 값이 가장 큰 Kevin이 우승한다.
     */
    @Test
    void 우승한_차량이_한_대() {
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
    }

    /**
     * 매 lap마다 각 자동차는 자신의 이름 길이 만큼 앞으로 전진한다.
     * 이름이 4글자 이상인 자동차만 앞으로 전진하게 되고 이름이 5글자인 자동차들이 우승하게 된다.
     */
    @Test
    void 우승한_차량이_두_대_이상() {
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
    }

    /**
     * 모든 자동차들이 동일한 거리를 laps회 전진한다.
     */
    @Test
    void 모든_차량이_동일한_거리_이동() {
        mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                .thenReturn(7);
        Referee referee = new Referee(cars);
        // when
        moveForwardForGivenLaps();
        // then
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        assertThat(referee.announceAllWinners()).isEqualTo(winners);
    }

    void moveForwardForGivenLaps() {
        for (int i = 0; i < this.laps; i++) {
            for (int j = 0; j < this.cars.size(); j++) {
                this.cars.get(j).moveForward();
            }
        }
    }
}
