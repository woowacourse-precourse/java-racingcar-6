package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.ExceptionMessage.DUPLICATE_CAR_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("입력에 중복된 문자 발생 시 예외 발생 ")
    public void 입력_자동차_중복된_이름_테스트() {
        String carNames = "woowaCar,woowaCar";
        try{
            new InputValidator(carNames);
        }catch(IllegalArgumentException e){
            assertThat(DUPLICATE_CAR_NAME).isEqualTo(e);
        }
    }
}