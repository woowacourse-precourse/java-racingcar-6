package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void initialize_초기값_검사() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("car1,car2,car3");
            List<Car> cars = Car.initialize();

            assertThat(cars.get(1).getName()).isEqualTo("car2");

            for (Car car : cars) {
                assertEquals(0, car.getMoveCount());
            }
        }
    }

    @Test
    void checkLength_자동차의_이름이_5이하가_아닐_때_예외_처리() {
        Car car = new Car("LeeJieun", 0);
        List<Car> carList = new ArrayList<>();
        carList.add(car);

        assertThatThrownBy(() -> Car.checkLength(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하로 작성해주세요.");
    }
}