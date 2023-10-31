package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("올바른 이름을 입력할 시 성공한다.")
    @Test
    void inputRightName(){
        String name = "Tomas";
        Car car = new Car(name);
        assertThat(name).isEqualTo(car.getName());
    }

    @DisplayName("비어있는 이름을 입력할 시 오류가 발생한다.")
    @Test
    void inputEmptyName(){
        String name = "";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }

    @DisplayName("길이가 5이상인 이름을 입력할 시 오류가 발생한다.")
    @Test
    void inputWrongLengthName(){
        String name = "kikiki";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }
}
