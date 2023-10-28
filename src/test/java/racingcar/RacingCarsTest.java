package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarsTest extends NsTest {

    private RacingCars racingCars;

    @BeforeEach
    void 경주자동차_생성() {
        racingCars = new RacingCars(List.of("car1", "car2", "car3"));
    }

    @Test
    void 경주자동차_호출() {
        List<Car> cars = racingCars.getAllCars();
        assertEquals(3, cars.size());
    }

    @Test
    void 경주자동차_이름_중복_예외_처리() {
        List<String> invalidNames = List.of("car1", "car1", "car2");
        assertThrows(IllegalArgumentException.class, () -> new RacingCars(invalidNames));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}