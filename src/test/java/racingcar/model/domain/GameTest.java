package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("게임 객체 생성을 테스트 합니다.")
    void 게임_객체_생성() {
        List<Car> cars = Arrays.asList(Car.from("pobi"));
        int trial = 3;
        Game game = Game.of(cars, trial);

        assertThat(game).isNotNull();
        assertThat(game.getCars().size()).isEqualTo(1);
        assertThat(game.getTrial()).isEqualTo(trial);
    }
}
