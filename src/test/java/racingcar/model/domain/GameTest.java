package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    private final String carName = "pobi";
    private final int trial = 1;
    private List<Car> cars;
    private Game game;

    @BeforeEach
    void setUp() {
        cars = List.of(Car.from(carName));
        game = Game.of(cars, trial);
    }

    @Test
    @DisplayName("게임 객체 생성을 테스트 합니다.")
    void 게임_객체_생성() {
        assertThat(game).isNotNull();
        assertThat(game).extracting(Game::getCars, Game::getTrial).containsExactly(cars, trial);
    }

    @Test
    @DisplayName("게임 객체 시도 횟수 증가에 따른 게임 종료를 테스트 합니다.")
    void 게임_종료() {
        game.increaseTrial();

        assertThat(game).isNotNull();
        assertThat(game).extracting(Game::getCars, Game::isFinished).containsExactly(cars, true);
    }
}
