package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameNumberLimitException;
import racingcar.exception.car.DuplicateCarNameException;

class CarValidatorTest {

    @Test
    @DisplayName("입력받은 문자열을 쉼표(,)기준으로 쪼개기")
    public void carsByStringToArray() {
        // given
        String input = "pobi,woni";
        String[] expectedCars = new String[]{"pobi", "woni"}; // expected
        // when
        String[] actualCars = CarValidator.carsByStringToArray(input); // actual
        assertThat(actualCars)
                .isNotNull()
                .isEqualTo(expectedCars);
    }

    @Test
    @DisplayName("[에러] 자동차 이름에 중복이 들어올 경우 IllegalArgumentException 발생")
    public void validateDuplicate() {
        //given
        String[] cars = new String[]{"pobi", "woni", "json", "pobi"};
        // when & then
        assertThatExceptionOfType(DuplicateCarNameException.class)
                .isThrownBy(() -> CarValidator.checkDuplicateCarName(cars))
                .withMessageMatching("자동차 이름은 중복이 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 없을 경우 set Collection 반환")
    public void validateNoDuplicate() {
        //given
        String[] cars = new String[]{"pobi", "woni", "json", "sejin"};
        Set<String> expectedCars = new HashSet<>(Arrays.asList(cars));
        // when
        Set<String> checkedCars = CarValidator.checkDuplicateCarName(cars);
        // then
        assertThat(checkedCars)
                .isNotNull()
                .isEqualTo(expectedCars);
    }

    @Test
    @DisplayName("자동차 이름이 6글자 이상일 경우 IllegalArgumentException 발생")
    public void checkOver5Letters() {
        // given
        String testCar = "javagili";

        // when & then
        assertThatExceptionOfType(CarNameNumberLimitException.class)
                .isThrownBy(() -> CarValidator.checkOver5Letters(testCar))
                .withMessageMatching("자동차 이름은 6글자 이상일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백만 있을 경우 IllegalArgumentException 발생")
    public void checkCarWithBlank() {
        // given
        String testCar = " ";

        // when & then
        assertThatExceptionOfType(BlankCarNameException.class)
                .isThrownBy(() -> CarValidator.checkCarWithBlank(testCar))
                .withMessageMatching("자동차 이름에 공백만 있을 수 없습니다.");
    }
}