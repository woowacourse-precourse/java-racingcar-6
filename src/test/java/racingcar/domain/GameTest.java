package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    @ParameterizedTest
    @ValueSource(strings = {"lion,tiger,bird"})
    @DisplayName("입력에 대한 차 리스트 생성 메서드 테스트")
    void generateCarListTest(String input) {
        // when
        Game game = new Game();
        Cars cars = game.generateCarList(input);

        // then
        assertThat(cars.getCars().get(0).getName()).isEqualTo("lion");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("tiger");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("bird");
    }
}