package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    static RacingCars racingCars;
    @BeforeAll
    static void initRacingCars() {
        List<String> list = List.of("pobi", "java");
        racingCars = new RacingCars(list);
    }

    @Test
    @DisplayName("자동차 이름이 올바르게 반환되는지 테스트")
    void testGetName() {
        List<String> testList = List.of("pobi", "java");
        List<RacingCar> racingCarsList = racingCars.carList;
        for (int i = 0; i < racingCarsList.size(); i++) {
            assertThat(racingCarsList.get(i).getName()).isEqualTo(testList.get(i));
        }
    }

    @Test
    @DisplayName("이동 횟수와 대쉬 문자열이 동일한지 테스트")
    void testGetDashString() {
        RacingCar racingCar = new RacingCar("pobi");
        for(int i = 0; i < 10; i++)
            racingCar.moveCar();
        assertThat(racingCar.getDashString().length()).isEqualTo(racingCar.getMoveNumber());
    }
}