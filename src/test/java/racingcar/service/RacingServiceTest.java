package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    @DisplayName("입력값을_쉼표를_기준으로_나누어_반환")
    void testSplitRacingCarsByComma() {
        // Given
        String input = "car1,car2,car3,car4";

        // When
        String[] result = racingService.splitRacingCarsByComma(input);
        String[] expected = {"car1", "car2", "car3", "car4"};

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력받은_자동차를_정상적으로_저장")
    void testSaveRacingCars() {
        // Given
        String[] cars = {"car1", "car2", "car3", "car4"};

        // When
        racingService.saveRacingCars(cars);
        List<RacingCar> racingCars = racingService.getRacingCars();

        // Then
        assertThat(cars.length).isEqualTo(racingCars.size());
    }

    @Test
    @DisplayName("자동차_한_대가_정상적으로_전진")
    void testProceedOneRacingCar() {
        // Given
        racingService.saveRacingCars(new String[]{"car1"});
        RacingCar car = racingService.getRacingCars().get(0);

        // When
        assertRandomNumberInRangeTest(
                () -> racingService.playOneRacing(),
                4
        );

        // Then
        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    @DisplayName("단일_우승자를_정상적으로_결정")
    void testGetWinnerName() {
        // Given
        String[] cars = {"car1", "car2", "car3", "car4"};
        racingService.saveRacingCars(cars);

        // When
        racingService.getRacingCars().get(1).plusMove(1);

        List<String> winner = racingService.getWinnerNames();

        // Then
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0)).isEqualTo("car2");
    }

    @Test
    @DisplayName("우승자가_여러_명일_경우_쉼표를_이용해_구분")
    void testGetWinnerNames() {
        // Given
        String[] cars = {"car1", "car2", "car3", "car4"};
        racingService.saveRacingCars(cars);

        // When
        racingService.getRacingCars().get(0).plusMove(1);
        racingService.getRacingCars().get(1).plusMove(1);

        List<String> winner = racingService.getWinnerNames();
        String result = String.join(",", winner);

        // Then
        assertThat(winner.size()).isEqualTo(2);
        assertThat(result).isEqualTo("car1,car2");
    }
}