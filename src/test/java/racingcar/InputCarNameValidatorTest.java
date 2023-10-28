package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputCarNameValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputCarNameValidatorTest {

    InputCarNameValidator inputCarNameValidator = new InputCarNameValidator();

    @Test
    @DisplayName("자동차 이름 입력을 안한 경우 테스트")
    void 자동차_이름_입력_안함_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputCarNameValidator.validateNonInputCarName(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 5자 초과한 경우")
    void 자동차_이름_5자_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputCarNameValidator.validateOverFiveCarName("pobizzang,woni,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 쉼표(,)가 아닌 다른 문자인 경우")
    void 자동차_이름_쉼표_아님_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputCarNameValidator.validateNonCommaCarName("pobi.woni,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 쉼표(,)가 아닌 다른 문자인 경우2")
    void 자동차_이름_쉼표_아님_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputCarNameValidator.validateNonCommaCarName("pobi/woni,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 쉼표(,)가 아닌 다른 문자인 경우3")
    void 자동차_이름_쉼표_아님_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputCarNameValidator.validateNonCommaCarName("pobi,woni-jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 쉼표(,)가 아닌 다른 문자인 경우4")
    void 자동차_이름_쉼표_아님_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputCarNameValidator.validateNonCommaCarName("pobi,woni&jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 잘 못 입력한 경우")
    void 자동차_이름_입력_형식_아님_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputCarNameValidator.validateWrongType("Pob!,Won~,j@@n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
