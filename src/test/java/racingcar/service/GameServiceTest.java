package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {

    private static RacingCars racingCars;
    private static GameService gameService;

    @BeforeEach
    void beforeEach() {

        racingCars = new RacingCars();
        gameService = new GameService();

        racingCars.setCars(new ArrayList<>(Arrays.asList("첫번째", "두번째", "세번째")));
    }


    @Test
    void 우승자가_단일인_경우() {

        racingCars.getCars().get(0).forwardLocation();
        gameService.getWinnerNames(racingCars);

        assertThat(racingCars.getWinners().get(0)).isEqualTo("첫번째");
    }

    @Test
    void 우승자가_여러명인_경우() {

        racingCars.getCars().get(0).forwardLocation();
        racingCars.getCars().get(1).forwardLocation();
        gameService.getWinnerNames(racingCars);

        assertThat(racingCars.getWinners()).containsExactly("첫번째", "두번째");
    }

}
