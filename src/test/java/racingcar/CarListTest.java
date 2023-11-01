package racingcar;

import racingcar.controller.CarList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarListTest {

    @Test
    public void splitCarInput_ShouldReturnValidCarNames_WhenInputIsCorrect() {
        CarList carList = new CarList();
        String carNames = carList.splitCarInput("Car1,Car2,Car3");
        assertThat(carNames).isEqualTo("Car1,Car2,Car3");
    }

    @Test
    public void splitCarInput_ShouldThrowIllegalArgumentException_WhenCarNameExceedsFiveCharacters() {
        CarList carList = new CarList();
        assertThatThrownBy(() -> carList.splitCarInput("Car1,CarThatHasALongName,Car3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자 이하로 작성해주세요.");
    }
}
