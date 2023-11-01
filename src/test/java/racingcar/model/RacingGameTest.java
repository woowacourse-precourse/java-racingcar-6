package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private RacingGame racingGame;
    private RandomNumberGenerator mockRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        CarNames carNames = new CarNames(List.of("pobi", "woni", "jun"));
        mockRandomNumberGenerator = mock(RandomNumberGenerator.class);
        racingGame = new RacingGame(carNames, mockRandomNumberGenerator);
    }

    @DisplayName("랜덤 값이 임계값 이상일 때 자동차가 전진한다")
    @Test
    void moveCarsAboveThreshold() {
        // given
        when(mockRandomNumberGenerator.generate()).thenReturn(5);

        // when
        racingGame.moveCars();

        // then
        racingGame.getRacingCars().forEach(car -> {
            assertThat(car.getPosition()).isEqualTo(1);
        });
    }

    @DisplayName("랜덤 값이 임계값 미만일 때 자동차는 전진하지 않는다")
    @Test
    void moveCarsBelowThreshold() {
        // given
        when(mockRandomNumberGenerator.generate()).thenReturn(3);

        // when
        racingGame.moveCars();

        // then
        racingGame.getRacingCars().forEach(car -> {
            assertThat(car.getPosition()).isEqualTo(0);
        });
    }

    @DisplayName("한 명의 승자룰 올바르게 결정한다.")
    @Test
    void determineWinner() {
        // given
        when(mockRandomNumberGenerator.generate()).thenReturn(5, 3, 2);

        // then
        racingGame.moveCars();
        List<RacingCar> winners = racingGame.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @DisplayName("여러 명의 승자룰 올바르게 결정한다.")
    @Test
    void determineWinners() {
        // given
        when(mockRandomNumberGenerator.generate()).thenReturn(5, 3, 5);

        // then
        racingGame.moveCars();
        List<RacingCar> winners = racingGame.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
        assertThat(winners.get(1).getName()).isEqualTo("jun");
    }
}