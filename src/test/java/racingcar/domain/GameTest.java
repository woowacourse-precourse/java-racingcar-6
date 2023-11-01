package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {
    private Game game;
    private static final List<String> CAR_NAMES = Arrays.asList("aa", "bb", "cc");

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

    @ParameterizedTest(name = "현재 결과 출력 테스트 : aa : {0}, bb : {1}, cc : {2}")
    @CsvSource({"1,2,3,aa : -, bb : --, cc : ---", "3,1,1,aa : ---, bb : -, cc : -"})
    void 현재_결과_출력_테스트(int score1, int score2, int score3, String expected1, String expected2, String expected3) {
        String expected = expected1 + "\n" + expected2 + "\n" + expected3 + "\n";
        String result = game.getCurrentResult(CAR_NAMES, Arrays.asList(score1, score2, score3));
        assertThat(result).isEqualTo(expected);
    }
}