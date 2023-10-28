package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;

class GameRequestDtoTest {
    @Test
    @DisplayName("GameRequestDto 생성자를 테스트 합니다.")
    void GameRequestDto_생성자_확인() {
        String trial = "3";
        GameRequestDto gameRequestDto = new GameRequestDto(trial);

        assertThat(gameRequestDto).isNotNull();
        assertThat(gameRequestDto.getTrial()).isEqualTo(Integer.parseInt(trial));
    }

    @Test
    @DisplayName("Game 객체 생성을 테스트 합니다.")
    void Game_객체_생성() {
        List<Car> cars = Arrays.asList(Car.from("pobi"));
        String trial = "3";
        GameRequestDto gameRequestDto = new GameRequestDto(trial);

        Game game = gameRequestDto.toGame(cars);

        assertThat(game).isNotNull();
        assertThat(game.getCars().get(0)).isEqualTo(cars.get(0));
        assertThat(game.getTrial()).isEqualTo(Integer.parseInt(trial));
    }
}