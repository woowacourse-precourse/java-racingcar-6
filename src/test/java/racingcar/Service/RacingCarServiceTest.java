package racingcar.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RacingCarServiceTest {
    @Test
    void 랜덤한_숫자_확인() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = RacingCarService.getRandomNumber();
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(10);
        }
    }

    @Test
    void playGame() {
        RacingCarService game = new RacingCarService();
        game.userInputRacingCar("A,B,C");
        game.userInputCount("5");
        game.initGame();
        while (!game.isWon()) {
            game.play();
        }
        assertThat(game.getCarDtoList().get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(game.getCarDtoList().get(0).getPosition()).isLessThanOrEqualTo(5);
        assertThat(game.getCarDtoList().get(1).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(game.getCarDtoList().get(1).getPosition()).isLessThanOrEqualTo(5);
        assertThat(game.getCarDtoList().get(2).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(game.getCarDtoList().get(2).getPosition()).isLessThanOrEqualTo(5);
    }

    @Test
    void userInputRacingCar() {
        RacingCarService game = new RacingCarService();
        game.userInputRacingCar("A,B,C");
        assertThat(game.getRacingCarCount()).isEqualTo(3);
    }

    @Test
    void userInputCount() {
        RacingCarService game = new RacingCarService();
        assertThatThrownBy(() -> game.userInputCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void userInputCount2() {
        RacingCarService game = new RacingCarService();
        assertThatThrownBy(() -> game.userInputCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void isWin() {
        RacingCarService game = new RacingCarService();
        game.userInputRacingCar("A,B,C");
        game.userInputCount("5");
        game.initGame();
        game.play();
        assertThat(game.isWon()).isNotNull();
    }
}
