package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest extends NsTest {

    @DisplayName("경주 자동차 목록 생성 테스트")
    @Test
    void createRacingCars() {
        //given
        RacingCars cars = new RacingCars();
        String carName = "pobi,dui,park,kim,jeon";

        //when
        List<Car> carList = cars.createRacingCars(carName);
        List<String> actualCarNames = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        //then
        List<String> expectedCarNames = Arrays.asList("pobi", "dui", "park", "kim", "jeon");
        assertEquals(expectedCarNames, actualCarNames);
    }

    @DisplayName("경주 자동차의 이동 테스트")
    @Test
    void moveCars() {
        //given
        RacingCars racingCars = new RacingCars();
        List<Car> carList = racingCars.createRacingCars("pobi,dui");

        // Mock 랜덤 숫자 생성
        assertRandomNumberInRangeTest(
                () -> racingCars.moveCars(carList),
                4, 3
        );

        // Then
        assertEquals(1, carList.get(0).getLocation());  // pobi의 위치
        assertEquals(0, carList.get(1).getLocation());  // dui의 위치
    }

    @Override
    protected void runMain() {

    }
}
