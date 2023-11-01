package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class CarNameValidatorTest {

    private CarNameValidator carNameValidator;
    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
    }

    @Test
    void 유요한_자동차_이름_길이() {
        //arrange
        String name = "valid";

        //act, assert
        assertThatCode(() -> carNameValidator.checkCarNameLength(name))
                .doesNotThrowAnyException();
    }

    @Test
    void 유요하지_않은_자동차_이름_길이() {
        //arrange
        String name = "failed";

        //act, assert
        assertThatThrownBy(() -> carNameValidator.checkCarNameLength(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이는 5 이하로 설정 해주세요.");
    }

    @Test
    void 중복되지_않는_자동차_이름들() {
        //arrange
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");

        //act, assert
        assertThatCode(() -> carNameValidator.checkDuplicatedCarName(carNames))
                .doesNotThrowAnyException();
    }
    @Test
    void 중복되는_값이_존재하는_자동차_이름들() {
        //arrange
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car1");

        //act, assert
        assertThatThrownBy(() -> carNameValidator.checkDuplicatedCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다");
    }
}