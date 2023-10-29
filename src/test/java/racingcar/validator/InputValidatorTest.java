package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static racingcar.constant.Constant.ZERO;
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
            inputValidator.hasDuplicatedName();
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
        inputValidator = new InputValidator(carNames);
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateCarNameLength()
                , "자동차 이름 중 5글자 초과한 자동차가 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름으로 공백을 사용할 수 없습니다.")
    public void 자동차_이름_공백_테스트() {
        carNames = "   \t , super,power, h    i , h `d ";
        inputValidator = new InputValidator(carNames);
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateEmptyCarName()
                , "모든 자동차 이름이 정상적으로 입력되었습니다.");
    }

    @Test
    @DisplayName("게임 진행 횟수에 숫자를 제외한 문자를 입력할 수 없습니다.")
    public void 게임_진행_횟수에_문자_입력_예외_테스트() {
        String wrongPlayTime = "1a";
        inputValidator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateNumber(wrongPlayTime)
                , "진행 횟수가 정상적으로 입력되었습니다.");
    }

    @Test
    @DisplayName("게임 진행 횟수에 0을 입력할 수 없습니다.")
    public void 게임_진행_횟수에_0_입력_예외_테스트() {
        inputValidator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateZero(ZERO)
                , "진행 횟수가 정상적으로 입력되었습니다.");
    }

}
