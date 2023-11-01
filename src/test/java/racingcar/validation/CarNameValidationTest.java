package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.InputManager;

public class CarNameValidationTest {
    InputManager inputManager;

    @BeforeEach
    public void beforeEach(){
        inputManager = new InputManager();
    }

    @Test
    void validateCarNames_성공() {
        //given
        String input = "pobi";
        List<Car> cars = new ArrayList<>();
        //when
        assertDoesNotThrow(() -> {
            inputManager.isValidateCarName(input,cars);
        });
    }

    @Test
    void isValidateCarName_실패_이름이_없는_경우() {
        //given
        String input = "";
        List<Car> cars = new ArrayList<>();
        //when
        assertThatThrownBy(() -> inputManager.isValidateCarName(input, cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName is empty");
    }

    @Test
    void isValidateCarName_실패_이름이_blank로만_이루어진_경우() {
        //given
        String input = "   ";
        List<Car> cars = new ArrayList<>();
        //when
        assertThatThrownBy(() -> inputManager.isValidateCarName(input, cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName is empty");
    }

    @Test
    void isValidateCarName_실패_5자리_이상() {
        //given
        String input = "우아한테크코스";
        List<Car> cars = new ArrayList<>();
        //when
        assertThatThrownBy(() -> inputManager.isValidateCarName(input, cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName length is over then 5");
    }

    @Test
    void isValidateCarName_이름이_이미_존재하는_경우() {
        //given
        String input = "pobi";
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        //when
        assertThatThrownBy(() -> inputManager.isValidateCarName(input, cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName already exists.");
    }
}
