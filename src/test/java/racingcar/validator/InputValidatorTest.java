package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.ExceptionMessage.DUPLICATE_CAR_NAME;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("문자열 내에 공백 제거 확인 테스트")
    public void 자동차_이름_공백_제거(){
        String carNames = "w  o,a   c, u      s, Second \t Week   \n ! , \t";
        InputValidator inputValidator =new InputValidator(carNames);
        List<String> carNameList = inputValidator.removeSpaceInCarName();
        assertThat(carNameList.get(0)).isEqualTo("wo");
        assertThat(carNameList.get(1)).isEqualTo("ac");
        assertThat(carNameList.get(2)).isEqualTo("us");
        assertThat(carNameList.get(3)).isEqualTo("SecondWeek!");
        assertThat(carNameList.get(4)).hasSize(0);
        assertThat(carNameList.size()).isEqualTo(5);
    }


}
