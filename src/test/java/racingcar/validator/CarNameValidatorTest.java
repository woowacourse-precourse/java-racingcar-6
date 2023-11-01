package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.constants.MessageConstants;
import racingcar.domain.Car;

public class CarNameValidatorTest {
    @Test
    void 유효한_차량_이름_검증() {
        String carName = "apple";
        assertThatCode(() -> CarNameValidator.validateCarName(carName)).doesNotThrowAnyException();
    }

    @Test
    void 길이가_초과된_차량_이름_존재_예외발생() {
        String carName = "banana";
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_CAR_NAME_FOR_LENGTH);
    }

    @Test
    void 공백이_포함된_차량_이름_존재_예외발생() {
        String carName = " ";
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_CAR_NAME_FOR_BLANK);
    }

    @Test
    void 빈_문자열인_차량_이름_존재_예외발생() {
        String carName = "";
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_CAR_NAME_FOR_BLANK);
    }

    @Test
    void 널_인_차량_이름_존재_예외발생() {
        String carName = null;
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_CAR_NAME_FOR_NULL);
    }

    @Test
    public void 중복된_차량_이름_존재_예외발생() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("woni"));
        carList.add(new Car("pobi"));
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_CAR_NAME_FOR_DUPLICATE_NAME);
    }
}