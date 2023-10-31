package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputViewValidatorTest {

    InputViewValidator inputViewValidator = InputViewValidator.getInstance();

    @Test
    void 입력_받은_차들의_이름이_공백이면_오류_발생() {
        String carName = "";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateCarNames(carName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 차 이름이 공백일 수 없습니다")
        );
    }

    @Test
    void 입력_받은_차들의_이름의_길이가_5_보다_크면_오류_발생() {
        String carName = "aaa,bbb,cccc,ddddd,eeeeee";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateCarNames(carName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 차 이름은 길이가 5이하여야 합니다")
        );
    }

    @Test
    void 입력_받은_차들의_이름이_중복_되면_오류_발생() {
        String carName = "벤츠,아우디,소나타,벤츠";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateCarNames(carName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 차 이름은 중복될 수 없습니다"));
    }

    @Test
    void 입력_받은_차들의_이름_중_하나가_공백일_때_오류_발생() {
        String carName = "벤츠,아우디,,소나타";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateCarNames(carName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 차 이름이 공백일 수 없습니다"));
    }

    @Test
    void 입력_받은_시도_횟수가_공백일_때_오류_발생() {
        String tryNumber = "";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateTryNumber(tryNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 시도 횟수가 공백일 수 없습니다"));
    }

    @Test
    void 입력_받은_시도_횟수가_정수가_아닐_때_오류_발생_1() {
        String tryNumber = "123ab";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateTryNumber(tryNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 시도 횟수는 정수 타입이어야 합니다.")
        );
    }

    @Test
    void 입력_받은_시도_횟수가_정수가_아닐_때_오류_발생_2() {
        String tryNumber = "12.3";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateTryNumber(tryNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 시도 횟수는 정수 타입이어야 합니다."));
    }

    @Test
    void 입력_받은_시도_횟수가_올바른_범위가_아닐_때_오류_발생_1() {
        String tryNumber = "-12";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateTryNumber(tryNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 시도 횟수는 1 이상이어야 합니다."));
    }

    @Test
    void 입력_받은_시도_횟수가_올바른_범위가_아닐_때_오류_발생_2() {
        String tryNumber = "02";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputViewValidator.validateTryNumber(tryNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] : 시도 횟수는 1 이상이어야 합니다.")
        );
    }
    
}