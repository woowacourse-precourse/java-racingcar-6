package racingcar.race.rule;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.model.Car;
import racingcar.car.model.CarName;
import racingcar.car.model.RacingCar;

class RandomRaceRuleTest {

    @Test
    void 단독우승_확인() {
        RaceRule randomRaceRule = new RandomRaceRule();
        ArrayList<Car> participantList = new ArrayList<>();
        participantList.add(new RacingCar(new CarName("p1")));
        participantList.add(new RacingCar(new CarName("p2")));
        participantList.add(new RacingCar(new CarName("p3")));

        participantList.get(0).moveForward();

        List<String> result = randomRaceRule.getWinner(participantList);
        assertTrue(result.contains("p1") && !result.contains("p2") && !result.contains("p3"));
    }

    @Test
    void 공동우승_확인() {
        RaceRule randomRaceRule = new RandomRaceRule();
        ArrayList<Car> participantList = new ArrayList<>();
        participantList.add(new RacingCar(new CarName("p1")));
        participantList.add(new RacingCar(new CarName("p2")));
        participantList.add(new RacingCar(new CarName("p3")));

        participantList.forEach(Car::moveForward);

        List<String> result = randomRaceRule.getWinner(participantList);
        assertTrue(result.contains("p1") && result.contains("p2") && result.contains("p3"));
    }

}