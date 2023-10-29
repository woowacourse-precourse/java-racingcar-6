package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static racingcar.constant.ExceptionMessage.DUPLICATE_CAR_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class InputValidatorTest {

    private String carNames;
    private InputValidator inputValidator;

    @Test
    @DisplayName("입력에 중복된 자동차 이름 발생 시 예외 발생 ")
    public void 입력_자동차_중복된_이름_테스트() {
        carNames = "waCar,waCar";
        try {
           inputValidator = new InputValidator(carNames);
           fail("중복된 자동차 이름이 없습니다.");
        } catch (IllegalArgumentException e) {
            assertThat(DUPLICATE_CAR_NAME.getMessage()).isEqualTo(e.getMessage());
        }
    }

    @Test
    @DisplayName("문자열 내에 공백 제거 확인 테스트")
    public void 자동차_이름_공백_제거() {
        carNames = "w  o,a   c, u      s, fi \t  ve  \n ! , \t b ";
        inputValidator = new InputValidator(carNames);
        List<String> carNameList = inputValidator.removeSpaceInCarName();
        assertThat(carNameList.get(0)).isEqualTo("wo");
        assertThat(carNameList.get(1)).isEqualTo("ac");
        assertThat(carNameList.get(2)).isEqualTo("us");
        assertThat(carNameList.get(3)).isEqualTo("five!");
        assertThat(carNameList.get(4)).hasSize(1);
        assertThat(carNameList.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름은 5글자를 초과할 수 없습니다.")
    public void 자동차_이름_길이_테스트() {
        carNames = "c  a \t r Len 7  , super";
        assertThrows(IllegalArgumentException.class, () -> new InputValidator(carNames)
        , "자동차 이름 중 5글자 초과한 자동차가 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름으로 공백을 사용할 수 없습니다.")
    public void 자동차_이름_공백_테스트() {
        carNames = "    , super,power, h    i , h `d , '\t ";
        assertThrows(IllegalArgumentException.class, () -> new InputValidator(carNames)
        , "모든 자동차 이름이 정상적으로 입력되었습니다.");
    }



}
