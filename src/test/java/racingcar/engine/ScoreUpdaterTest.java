package racingcar.engine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Score;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ScoreUpdaterTest {
    private static final int NUMBER_GENERATOR_START_INCLUSIVE = 0;
    private static final int NUMBER_GENERATOR_END_INCLUSIVE = 9;
    private static final int ADD_SCORE_POINT = 4;
    private static final Long PLUS_SCORE = 1L;

    private static int[] 점수가_그대로인_경우() {
        return IntStream.range(NUMBER_GENERATOR_START_INCLUSIVE, ADD_SCORE_POINT).toArray();
    }

    private static int[] 점수가_업데이트가_되는_경우() {
        return IntStream.range(ADD_SCORE_POINT, NUMBER_GENERATOR_END_INCLUSIVE + 1).toArray();
    }

    @ParameterizedTest
    @MethodSource("점수가_그대로인_경우")
    void 숫자가_0_3까지는_전진하지않는다(int numberGeneratorReturnValue) {
        Long expect = 0L;
        List<Score> scores = Stream.of(new Score("", expect)).toList();
        new ScoreUpdater(new ReturnGenerator(numberGeneratorReturnValue)).updateScore(scores);
        Assertions.assertThat(scores.get(0).getScore()).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("점수가_업데이트가_되는_경우")
    void 숫자가_4_9까지는_점수가오른다(int numberGeneratorReturnValue) {
        Long init = 0L;
        Long expect = init + PLUS_SCORE;
        List<Score> scores = Stream.of(new Score("", init)).toList();
        new ScoreUpdater(new ReturnGenerator(numberGeneratorReturnValue)).updateScore(scores);
        Assertions.assertThat(scores.get(0).getScore()).isEqualTo(expect);
    }
}