package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    @DisplayName("횟수 1회 진행 테스트")
    void 횟수_1회_진행_테스트() {
        List<Integer> carScores = Arrays.asList(1, 1, 1);
        List<Integer> result = game.movingCars(carScores);

        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i)).isIn(1, 2);
        }
    }
}