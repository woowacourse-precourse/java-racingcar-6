package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.utils.CarListValidator;

public class CarListValidatorTest {
    @Test
    @DisplayName("중복된 이름이 입력된 경우 IellgalException 에러를 반환한다.")
    void carListInvalidatorTest() throws Exception{
        //given
        List<Car> carList = new ArrayList<>(List.of(new Car(new Name("Pobi")),new Car(new Name("Pobi"))));

        //when, then
        assertThatThrownBy(() -> {
            CarListValidator.validate(carList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 1개만 입력된경우 IellgalException 에러를 반환한다.")
    void carListInvalidatorTest2() throws Exception{
        //given
        List<Car> carList = new ArrayList<>(List.of(new Car(new Name("Pobi"))));

        //when, then
        assertThatThrownBy(() -> {
            CarListValidator.validate(carList);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
