package racingcar.Model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("최종 우승자 이름 가져오기 - 한 명인 경우")
    void getWinnerTestOne() {
        cars.testMove(0);

        List<String> expectResult = Arrays.asList("pobi");

        assertThat(cars.getWinner()).isEqualTo(expectResult);
    }
    @Test
    @DisplayName("최종 우승자 이름 가져오기 - 여러 명인 경우")
    void getWinnerTest() {
        List<String> expectResult = Arrays.asList("pobi", "woni", "jun", "Joana");

        assertThat(cars.getWinner()).isEqualTo(expectResult);
    }

}