package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;

class GameRequestDtoTest {
    private List<Car> cars;
    private GameRequestDto gameRequestDto;
    private final int trial = 3;

    @BeforeEach
    void setUp() {
        cars = List.of(Car.from("pobi"));
        gameRequestDto = new GameRequestDto(String.valueOf(trial));
    }

    @Test
    @DisplayName("GameRequestDto 생성자를 테스트 합니다.")
    void GameRequestDto_생성자_확인() {
        assertThat(gameRequestDto).isNotNull();
        assertThat(gameRequestDto).extracting(GameRequestDto::getTrial).isEqualTo(trial);
    }

    @Test
    @DisplayName("Game 객체 생성을 테스트 합니다.")
    void Game_객체_생성() {
        Game game = gameRequestDto.toGame(cars);

        assertThat(game).isNotNull();
        assertThat(game).extracting(Game::getCars).isEqualTo(cars);
        assertThat(game).extracting(Game::getTrial).isEqualTo(trial);
    }
}