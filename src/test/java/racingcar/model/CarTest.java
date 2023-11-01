package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private CarValidator carValidator;

    @BeforeEach
    void setUp() {
        carValidator = new CarValidator();
        car = new Car(carValidator);
    }

    @Test
    void 자동차_정상_입력_확인() {
        String cars = "pobi,woni,jun";
        List<String> carList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));

        assertThat(carList).isEqualTo(car.extractCarList(cars));
    }
}
