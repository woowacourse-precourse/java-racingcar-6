package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameValidatorTest {
    private CarNameValidator carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
    }
    
    @Test
    @DisplayName("구분자가 쉼표가 아닐때")
    void 구분자가_쉼표가_아닌_경우() throws Exception {
        //given
        String carNames = "car1.car2,car3";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validate(carNames))
                .withMessage(ErrorMessage.NOT_COMMA_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("차 이름을 한대만 입력했을 때")
    void 차_이름을_한대만_입력한_경우() throws Exception {
        //given
        String carNames = "car1";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validate(carNames))
                .withMessage(ErrorMessage.CAR_NUM_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("차 이름이 5글자를 초과한 경우에 대한 테스트")
    void 차_이름이_5글자를_초과한_경우() throws Exception {
        //given
        String carNames = "helloworld,car2,car3";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validate(carNames))
                .withMessage(ErrorMessage.OVER_LENGTH_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("차 이름이 중복된 경우에 대한 테스트")
    void 차_이름이_중복된_경우() throws Exception {
        //given
        String carNames = "car1,car1,car3";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validate(carNames))
                .withMessage(ErrorMessage.DUPLE_CAR_NAME_ERROR.getErrorMessage());
    }
}