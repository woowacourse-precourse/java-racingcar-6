package racingcar.domain.race.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.race.car.Car;
import racingcar.domain.race.car.Engine;
import racingcar.domain.race.dto.Distance;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceRecordTest {
    private final String FORWARD_SYMBOL = "-";
    private RaceRecord raceRecord = RaceRecord.newInstance();
    private Car car1;
    private Car car2;

    @BeforeEach
    void beforeInitialize() {
        car1 = Car.of("테스트1", Engine.newInstance());
        car2 = Car.of("테스트2", Engine.newInstance());
        raceRecord.addCarToRace(car1);
        raceRecord.addCarToRace(car2);
    }

    @AfterEach
    void clear() {
        car1 = null;
        car2 = null;
        raceRecord = RaceRecord.newInstance();
    }

    @Test
    void 자동차_경주_결과_무승부_테스트() {
        // given
        // when
        raceRecord.moveForward(car1, FORWARD_SYMBOL);
        raceRecord.moveForward(car2, FORWARD_SYMBOL);

        Distance distanceForCar1 = raceRecord.getDistanceForCar(car1);
        Distance distanceForCar2 = raceRecord.getDistanceForCar(car2);

        // then
        assertThat(distanceForCar1.getLength())
                .isEqualTo(distanceForCar2.getLength());
    }

    @Test
    void 자동차_경주_결과_car1_승리_테스트() {
        // given
        // when
        raceRecord.moveForward(car1, FORWARD_SYMBOL);
        raceRecord.moveForward(car1, FORWARD_SYMBOL);
        raceRecord.moveForward(car2, FORWARD_SYMBOL);

        Distance distanceForCar1 = raceRecord.getDistanceForCar(car1);
        Distance distanceForCar2 = raceRecord.getDistanceForCar(car2);

        // then
        assertThat(distanceForCar1.getLength())
                .isGreaterThan(distanceForCar2.getLength())
        ;
    }

    @Test
    void 자동차_경주_결과_car2_승리_테스트() {
        // given
        // when
        raceRecord.moveForward(car1, FORWARD_SYMBOL);
        raceRecord.moveForward(car2, FORWARD_SYMBOL);
        raceRecord.moveForward(car2, FORWARD_SYMBOL);

        Distance distanceForCar1 = raceRecord.getDistanceForCar(car1);
        Distance distanceForCar2 = raceRecord.getDistanceForCar(car2);

        // then
        assertThat(distanceForCar1.getLength())
                .isLessThan(distanceForCar2.getLength())
        ;
    }

    @Test
    void 우승자_조회_성공_테스트() {
        // given
        String winnerName = "테스트1";
        int winnersDistance = 2;

        // when
        raceRecord.moveForward(car1, FORWARD_SYMBOL);
        raceRecord.moveForward(car1, FORWARD_SYMBOL);

        raceRecord.moveForward(car2, FORWARD_SYMBOL);

        List<Car> winners = raceRecord.findWinners(winnersDistance);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo(car1);
        assertThat(winners.get(0).getName()).isEqualTo(winnerName);
    }

}