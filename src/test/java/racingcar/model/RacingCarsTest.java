package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import racingcar.Application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarsTest extends NsTest {

    private RacingCars racingCars;

    @BeforeEach
    void 경주자동차_생성() {
        racingCars = new RacingCars(List.of("car1", "car2", "car3"));
    }

    @Test
    void 경주자동차_자동차_생성메소드() {
        racingCars = new RacingCars(List.of("car1", "car2", "car3"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        assertThat(racingCars.getAllCars().containsAll(cars));
    }

    @Test
    void 경주자동차_리스트_호출_메소드() {
        List<Car> cars = racingCars.getAllCars();
        assertEquals(3, cars.size());
    }

    @Test
    void 경주자동차_이름_중복_예외_처리() {
        List<String> invalidNames = List.of("k-3", "k-5", "k-5");
        assertThrows(IllegalArgumentException.class, () -> new RacingCars(invalidNames));
    }

    @Test
    void 경주자동차_길이_초과_예외_처리() {
        List<String> invalidNames = List.of("car1", "5431132", "car2");
        assertThrows(IllegalArgumentException.class, () -> new RacingCars(invalidNames));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}