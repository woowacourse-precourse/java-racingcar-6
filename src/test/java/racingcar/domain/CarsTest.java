package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;
    private String input;
    private static final String racer1 = "ford";
    private static final String racer2 = "bulls";
    private static int NumberOfRacer = 2;

    @BeforeEach
    void init() {
        this.cars = new Cars();
        this.input = racer1 + "," + racer2;
    }

    @Test
    @DisplayName("입력에 따른 참가 자동차들 참가되었는지 테스트 - 성공")
    void join() {

        cars.join(input);

        List<Car> carList = this.cars.getCars();
        assertAll(
                () -> assertThat(carList.get(0).getName()).isEqualTo(racer1),
                () -> assertThat(carList.get(1).getName()).isEqualTo(racer2),
                () -> assertThat(carList.size()).isEqualTo(NumberOfRacer)
        );

    }
}