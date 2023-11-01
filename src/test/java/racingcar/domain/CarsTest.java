package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import racingcar.constants.DomainConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.ValidatorConstant;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름은 쉼표(,)로 구분하여 리스트에 저장하는지 테스트")
    void testCarNamesSplitAndStore() {
        Cars cars = new Cars("tiger,eagle,bear");

        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        List<String> expectedList = Arrays.asList("tiger", "eagle", "bear");

        Assertions.assertThat(carNames).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("자동차 이름 중 최대길이 이상의 이름 포함 시 에러 발생 테스트")
    void testCarNamesContainsNameLengthOverThanMaxLength() {
        IllegalArgumentException carsNameError =
                assertThrows(IllegalArgumentException.class, () -> new Cars("tiger,eagle,leopard"));
        assertThat(carsNameError.getMessage()).isEqualTo(ValidatorConstant.carNameErrorMessage);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 반환하는지 테스트 - 단독 우승자")
    void testMostMovedCarIsSoloWinner() {
        Cars cars = new Cars("tiger,eagle,bear");

        int drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 1;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 2;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        Assertions.assertThat(cars.getWinnersName()).isEqualTo(Arrays.asList("bear"));
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 반환하는지 테스트 - 공동 우승자")
    void testMostMovedCarIsCoWinner() {
        Cars cars = new Cars("tiger,eagle,bear");

        int drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 1;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        drivingSkill = DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE + 1;
        for (Car car : cars) {
            car.move(drivingSkill++);
        }

        Assertions.assertThat(cars.getWinnersName()).isEqualTo(Arrays.asList("eagle", "bear"));
    }
}
