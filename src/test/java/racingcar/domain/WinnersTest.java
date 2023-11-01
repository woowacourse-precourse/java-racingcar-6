package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {

    @Test
    void 경주_우승자_이름_테스트() {
        List<Car> winners = new ArrayList<>();

        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        winners.add(car1);
        winners.add(car2);

        List<String> winnersName = new Winners(winners).getWinnersName();

        List<String> expectedName = new ArrayList<>();
        expectedName.add("pobi");
        expectedName.add("woni");

        assertTrue(expectedName.equals(winnersName));
    }
}