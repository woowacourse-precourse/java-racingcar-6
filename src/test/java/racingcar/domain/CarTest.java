package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;

public class CarTest {

    @Test
    public void 자동차객체하나_생성_문자이름으로() {
        // given
        String name = "pobi";

        // when
        Car car = Car.create(name);

        // then
        assertEquals(name, car.getName());
    }

    @Test
    public void 자동차객체리스트_생성_문자이름리스트로() {
        // given
        List<String> nameList = Arrays.asList("pobi", "woni");

        // when
        List<Car> carList = Car.createList(nameList);

        // then
        assertEquals(2, carList.size());
        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
    }
}