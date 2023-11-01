package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidatorTest {

    @Test
    void 기준_길이_초과하는_이름은_예외_발생() {
        String inputCarName = "다섯글자 넘는 자동차 이름";
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Length must be less or equal than")
        );
    }

    @Test
    void 이름이_비어있거나_공백으로만_이루어져_있는_경우_예외_발생() {
        String inputCarName = " ";
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Car name cannot be blank")
        );
    }

    @Test
    void 자동차_이름이_중복일_경우_예외_발생() {
        List<Car> carList = Arrays.asList(
                mock(Car.class),
                mock(Car.class),
                mock(Car.class)
        );

        when(carList.get(0).getName()).thenReturn("중복");
        when(carList.get(1).getName()).thenReturn("중복");
        when(carList.get(2).getName()).thenReturn("중복아님");

        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkDuplicateName(carList))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Name must not be duplicated")
        );
    }

    @Test
    void 실행_횟수_입력이_숫자가_아니거나_int_범위보다_클_경우_예외_발생() {
        String inputCountTry = "13412413541234234";
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkTryCountInput(inputCountTry))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Try count input is invalid")
        );
    }
}
