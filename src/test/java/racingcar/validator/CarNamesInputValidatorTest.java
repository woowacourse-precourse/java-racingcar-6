package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.GameConstant;
import racingcar.constant.message.CarNamesInputErrorMessage;

public class CarNamesInputValidatorTest {
    @DisplayName("비어있는 차량 리스트 입력에 대한 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 비어있는_차량_리스트_입력시_예외_발생() {
        // given
        final CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator();

        // when
        final String input = "";

        // then
        assertThatThrownBy(() -> carNamesInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
    }

    @DisplayName("쉼표(,)로 구분된 차량 리스트 중 비어있는 값이 있을 때 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 쉼표로_구분된_차량_리스트_안에_비어있는_값이_있을떄_예외_발생() {
        // gien
        final CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator();

        // when
        final String input = "abc,,def";

        // then
        assertThatThrownBy(() -> carNamesInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
    }

    @DisplayName("쉼표(,) 없는 차량 리스트 입력에 대한 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 쉼표_없는_차량_리스트_입력시_예외_발생() {
        // given
        final CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator();

        // when
        final String input = "abc";

        // then
        assertThatThrownBy(() -> carNamesInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNamesInputErrorMessage.INPUT_DOES_NOT_CONTAIN_DELIMITER);
    }

    @DisplayName("차량 리스트 입력의 마지막이 쉼표(,)로 끝날 때 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 마지막_글자가_쉼표인_차량_리스트_입력시_예외_발생() {
        // given
        final CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator();

        // when
        final String input = "a,b,c,d,";

        // then
        assertThatThrownBy(() -> carNamesInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
    }

    @DisplayName("입력된 차량 중" + GameConstant.CAR_NAME_MAX_LENGTH + "글자 초과의 입력이 존재하면 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 다섯_글자_초과_차량_이름_입력시_예외_발생() {
        // given
        final CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator();

        // when
        final String[] input = {"abcdefg,abc", "abcd,efg,hijklmno", "abc e ,ad", "     e,b"};

        // then
        for (String s : input) {
            assertThatThrownBy(() -> carNamesInputValidator.validate(s))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CarNamesInputErrorMessage.INPUT_LENGTH_EXCEEDS_LIMIT);
        }
    }

    @DisplayName("각 요소별 공백이 없이 입력된 차량 리스트에, 중복된 차 이름이 존재하면 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 공백_없는_차량_이름들중_중복된_차_이름_존재시_예외_발생() {
        // given
        final CarNamesInputValidator carNamesInputValidator = new CarNamesInputValidator();

        // when
        final String[] input = {"ail,bil,cil,cil",
                "bil,ail,ail,cil", "cil,cil,cil,ail,ail", "cil,ail,cil",
                "bil,bil,bil,bil,bil"};

        // then
        for (String s : input) {
            assertThatThrownBy(() -> carNamesInputValidator.validate(s))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CarNamesInputErrorMessage.INPUT_CAR_NAME_IS_DUPLICATED);
        }
    }
}