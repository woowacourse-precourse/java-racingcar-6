package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class CarUnitTest {

    @Test
    void getCurrentStatus_자동차의_이름과_현재_위치_반환() {
        Car testCar = new Car("Test");

        String result = testCar.getCurrentStatus();

        assertThat(result).startsWith("Test").endsWith("0").contains(":");
    }

    @Test
    void determineWhetherToMove_자동차의_이동_여부_결정() {
        int moveCondition = 5;
        int stopCondition = 3;
        Car testCar = new Car("Test");

        boolean moveTest = testCar.determineWhetherToMove(moveCondition);
        boolean stopTest = testCar.determineWhetherToMove(stopCondition);

        assertThat(moveTest).isEqualTo(true);
        assertThat(stopTest).isEqualTo(false);
    }

    @Test
    void move_자동차_이동() {
        Car testCar = new Car("Test");
        ArrayList<Integer> possibleLocations = new ArrayList<>(3);
        possibleLocations.add(0);
        possibleLocations.add(1);
        possibleLocations.add(2);

        testCar.move();
        testCar.move();

        assertThat(testCar).extracting("currentLocation").isIn(possibleLocations);
    }
}
