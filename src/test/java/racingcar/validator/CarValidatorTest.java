package racingcar.validator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarValidatorTest {

    @Test
    void 이름이_하나도_없는_경우_예외_발생() {
        String[] carNames = new String[0];
        CarValidator carValidator = new CarValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carValidator.checkInput(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("At least one car required")
        );
    }

    @Test
    void 이름이_기준_길이_초과하는_경우_예외_발생() {
        String[] inputCarName = new String[]{"다섯글자 넘는 자동차 이름"};
        CarValidator carValidator = new CarValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carValidator.checkInput(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Length must be less or equal than")
        );
    }

    @Test
    void 이름이_비어있는_경우_예외_발생() {
        String[] inputCarName = new String[]{""};
        CarValidator carValidator = new CarValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carValidator.checkInput(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Car name cannot be blank")
        );
    }

    @Test
    void 이름이_공백으로만_이루어져_있는_경우_예외_발생() {
        String[] inputCarName = new String[]{"  "};
        CarValidator carValidator = new CarValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carValidator.checkInput(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Car name cannot be blank")
        );
    }

    @Test
    void 자동차_이름이_중복일_경우_예외_발생() {
        String[] inputCarName = new String[]{"중복", "중복"};

        CarValidator carValidator = new CarValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carValidator.checkInput(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Name must not be duplicated")
        );
    }
}
