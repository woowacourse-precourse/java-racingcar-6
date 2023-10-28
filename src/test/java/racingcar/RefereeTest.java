package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.factories.CarFactory;
import racingcar.factories.CarRecordFactory;

public class RefereeTest {

    String[] names;
    private static GameRule rule;
    private Referee referee;
    private CarRecord carRecord;
    private static int laps;
    private static MockedStatic<RandomNumberGenerator> mocked;

    @BeforeEach
    private void setCarsAndReferee() {
        carRecord = CarRecordFactory.createEmptyCarRecord();
        names = new String[] {"Max", "Lando", "Lewis", "Oscar", "Alex", "Sainz", "Kevin"};
        for (int i = 0; i < names.length; i++) {
            carRecord.register(CarFactory.car(rule, names[i]));
        }
        referee = new Referee(carRecord);
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
     * 기존의 자동차들은 0만큼 움직이고 winner 자동차는 5만큼 움직인다.
     * 승자는 winner 한 명이다.
     */
    @Test
    void 우승한_차량이_한_대() {
        // when
        setDistance(3);
        for (int i = 0; i < laps; i++) {
            carRecord.moveForwardAllCars();
        }
        Car winner = getCarMovedFor(5, "Nick");
        winner.moveForward();
        carRecord.register(winner);
        // then
        assertThat(referee.announceAllWinners()).isEqualTo(winner.getName());
    }

    /**
     * 기존 차량들은 5씩 laps회 만큼 이동한다.
     * winners 자동차들은 9씩 laps회 만큼 이동한다.
     */
    @Test
    void 우승한_차량이_두_대_이상() {
        // when
        setDistance(3);
        for (int i = 0; i < laps; i++) {
            carRecord.moveForwardAllCars();
        }
        CarRecord winners = CarRecordFactory.createEmptyCarRecord();
        Car w1 = CarFactory.car(rule, "w1");
        Car w2 = CarFactory.car(rule, "w2");
        Car w3 = CarFactory.car(rule, "w3");
        setDistance(9);
        for (int i = 0; i < laps; i++) {
            w1.moveForward();
            w2.moveForward();
            w3.moveForward();
        }
        winners.register(w1);
        winners.register(w2);
        winners.register(w3);
        carRecord.register(w1);
        carRecord.register(w2);
        carRecord.register(w3);
        // then
        assertThat(referee.announceAllWinners()).isEqualTo(winners.toString());
    }

    /**
     * 모든 자동차들이 동일한 거리를 laps회 전진한다.
     */
    @Test
    void 모든_차량이_동일한_거리_이동() {
        // when
        setDistance(7);
        for (int i = 0; i < laps; i++) {
            carRecord.moveForwardAllCars();
        }
        // then
        assertThat(referee.announceAllWinners()).isEqualTo(String.join(", ", names));
    }

    Car getCarMovedFor(int distance, String name) {
        Car car = CarFactory.car(rule, name);
        mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                .thenReturn(distance);
        car.moveForward();
        return car;
    }

    void setDistance(int distance) {
        mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                .thenReturn(distance);
    }
}
