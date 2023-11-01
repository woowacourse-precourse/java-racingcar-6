package racingcar;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.GameService;

class InputValidatorTest {

    private final GameService gameService = new GameService();

    @Test
    void is_car_name_null() {
        List<Car> carList = Arrays.asList(new Car(null),
                new Car("자동차2"), new Car("자동차3"));

        try {
            gameService.validateInput(carList);
        } catch (Exception e) {
            assert (e instanceof IllegalArgumentException);
        }
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는지 테스트")
    void is_name_too_long() {
        List<Car> carList = List.of(new Car("이름이 긴 아이"));

        try {
            gameService.validateInput(carList);
        } catch (Exception e) {
            assert (e instanceof IllegalArgumentException);
        }
    }

    @Test
    @DisplayName("자동차 이름이 중복되는지 테스트")
    void is_name_duplicate() {
        List<Car> carList = Arrays.asList(new Car("이름1"), new Car("이름2"), new Car("이름1"));

        try {
            gameService.validateInput(carList);
        } catch (Exception e) {
            assert (e instanceof IllegalArgumentException);
        }
    }
}
