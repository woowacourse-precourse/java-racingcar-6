package validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validate.CarNamesValidation;
import racingcar.validate.UserInputValidation;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarNamesValidationTest {
    private UserInputValidation<List<String>> validation;

    @BeforeEach
    public void setUp() {
        validation = new CarNamesValidation();
    }

    @DisplayName("자동차의 수가 5개 이상일 때 false 를 반환한다.")
    @Test
    public void carNamesValidationTest() {
        // given
        List<String> cars = List.of("KWY", "DSH", "WEB", "PLAN", "DEV", "FE");
        // when
        boolean result = validation.validate(cars);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("자동차들 중 이름이 5글자 이상인 자동차가 있을 때 false 를 반환한다.")
    @Test
    public void carNamesValidationTest2() {
        // given
        List<String> cars = List.of("KWY", "SERVER", "WEB");
        // when
        boolean result = validation.validate(cars);
        // then
        assertThat(result).isFalse();
    }
}
