package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import racingcar.global.exception.ErrorMessage;
import racingcar.global.util.RandomNumberGenerator;

class CarsTest {
    private static MockedStatic<RandomNumberGenerator> generator;

    @BeforeAll
    public static void beforeALl() {
        generator = mockStatic(RandomNumberGenerator.class);
    }

    @AfterAll
    public static void afterAll() {
        generator.close();
    }

    @Test
    @DisplayName("자동차 이름의 입력으로 Cars 객체를 생성한다.")
    void generateToCarsTest() {
        // given
        List<String> names = Arrays.asList("car1", "car2", "car3");
        Cars cars = new Cars(names);

        // when & then
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("5자 초과의 이름 입력으로 예외가 발생한다.")
    void TooLongCarNameError() {
        // given
        List<String> names = Arrays.asList("carrrrrr", "car");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LENGTH_ERROR.getMessage());
    }

    @Test
    @DisplayName("단일 우승자를 성공적으로 가려낸다.")
    void selectSingleWinnersTest() {
        // given
        List<String> names = Arrays.asList("car1", "car2", "car3");
        BDDMockito.given(RandomNumberGenerator.generate(anyInt(), anyInt()))
                .willReturn(3, 6, 1);
        Cars cars = new Cars(names);

        // when
        cars.moveCars();
        List<String> winners = cars.selectWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("car2");
    }

    @Test
    @DisplayName("복수의 우승자를 성공적으로 가려낸다.")
    void selectCoupleWinnersTest() {
        // given
        List<String> names = Arrays.asList("car1", "car2", "car3");
        BDDMockito.given(RandomNumberGenerator.generate(anyInt(), anyInt()))
                .willReturn(4, 6, 1);
        Cars cars = new Cars(names);

        // when
        cars.moveCars();
        List<String> winners = cars.selectWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("car1");
        assertThat(winners.get(1)).isEqualTo("car2");
    }
}
