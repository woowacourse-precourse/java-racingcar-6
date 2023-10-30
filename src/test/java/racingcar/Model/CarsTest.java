package racingcar.Model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Util.CarMovement;

class CarsTest {

    private Cars cars = new Cars();

    @BeforeEach
    void setUp() {
        String[] str = {"pobi", "woni", "jun", "Joana"};

        cars.addCar(str);
    }

    @Test
    @DisplayName("차의 총 대수 테스트")
    void carsLengthTest() {
        assertEquals(cars.carsLength(), 4);
    }

    @Test
    @DisplayName("최종 우승자 이름 가져오기 - 여러 명인 경우")
    void getWinnerTest() {
        List<String> expectResult = Arrays.asList("pobi", "woni", "jun", "Joana");

        assertThat(cars.getWinner()).isEqualTo(expectResult);
    }
}