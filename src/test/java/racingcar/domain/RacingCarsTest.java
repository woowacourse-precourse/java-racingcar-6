package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    static RacingCars racingCars;

    @BeforeAll
    static void initRacingCars() {
        List<String> list = List.of("pobi", "java");
        racingCars = new RacingCars(list);
    }

    @Test
    @DisplayName("자동차 이름이 올바르게 저장되었는지 테스트")
    void testCarsNameValues() {
        List<RacingCar> carList = racingCars.getCarList();
        List<String> nameTestList = List.of("pobi", "java");

        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getName()).isEqualTo(nameTestList.get(i));
        }
    }
}