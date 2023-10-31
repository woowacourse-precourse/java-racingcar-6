package racingcar.engine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Score;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class GameEngineTest {
    private static final int MAX_SIZE = 5;
    private static final int NUMBER_GENERATOR_START_INCLUSIVE = 0;
    private static final int NUMBER_GENERATOR_END_INCLUSIVE = 9;
    private static final int ADD_SCORE_POINT = 4;
    private static final Long PLUS_SCORE = 1L;

    private static String[] 점수_생성이_안되는_케이스() {
        return new String[]{" ".repeat(MAX_SIZE + 1), "123456789"};
    }

    private static String[] 점수_생성이_되는_케이스() {
        return new String[]{" ".repeat(MAX_SIZE), "12345"};
    }

    private static String[] 시도한_횟수값이_마이너스이거나_숫자가_아니거나_null_경우() {
        return new String[]{" ".repeat(MAX_SIZE), null, "qwe", "ㅁㄴㅇ", "ㅃ", "Q", "★", "-123", "-123456789", "-1", "1-1"};
    }

    private static int[] 점수가_그대로인_경우() {
        return IntStream.range(NUMBER_GENERATOR_START_INCLUSIVE, ADD_SCORE_POINT).toArray();
    }

    private static int[] 점수가_업데이트가_되는_경우() {
        return IntStream.range(ADD_SCORE_POINT, NUMBER_GENERATOR_END_INCLUSIVE + 1).toArray();
    }

    private static Stream<Arguments> 우승자가_있는케이스() {
        return Stream.of(
                Arguments.of("12", Arrays.asList(ADD_SCORE_POINT - 1, ADD_SCORE_POINT + 1), List.of("12"), List.of(0L))
                , Arguments.of("12,13", Arrays.asList(ADD_SCORE_POINT - 1, ADD_SCORE_POINT + 1), List.of("13"), List.of(1L))
                , Arguments.of("12,13", Arrays.asList(ADD_SCORE_POINT, ADD_SCORE_POINT), List.of("12", "13"), List.of(1L, 1L))
        );
    }

    @Test
    void 플레이어이름이_null이면_예외를_던진다() {
        Assertions.assertThatCode(() -> new GameEngine(new ScoreUpdater(new ReturnGenerator()), new GameEngineValidator()).initScore(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
        ;
    }

    @ParameterizedTest
    @MethodSource("점수_생성이_안되는_케이스")
    void 플레이어이름이_6이상이면_예외를_던진다(String readLine) {
        Assertions.assertThatCode(() -> new GameEngine(new ScoreUpdater(new ReturnGenerator()), new GameEngineValidator()).initScore(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class)
        ;
    }

    @ParameterizedTest
    @MethodSource("점수_생성이_되는_케이스")
    void 플레이어이름이_5이하이면_예외를_던지지_않는다(String readLine) {
        Assertions.assertThatCode(() -> new GameEngine(new ScoreUpdater(new ReturnGenerator()), new GameEngineValidator()).initScore(readLine))
                .doesNotThrowAnyException();
    }

    @Test
    void 플레이어이름은_한번만_설정된다() {
        GameEngine gameEngine = new GameEngine(new ScoreUpdater(new ReturnGenerator()), new GameEngineValidator());
        String expect = "";
        gameEngine.initScore(expect);
        gameEngine.initScore("123");
        Assertions.assertThat(gameEngine.getWinners().get(0).getName()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({
            "12",
            "1,2"
    })
    void 같은점수면_우승자순서대로_나오게한다(String playerNames) {
        List<Score> expectWinners = Arrays.stream(playerNames.split(",")).map(name -> new Score(name, 0L)).toList();
        GameEngine gameEngine = new GameEngine(new ScoreUpdater(new ReturnGenerator()), new GameEngineValidator());
        gameEngine.initScore(playerNames);
        List<Score> resultWinners = gameEngine.getWinners();
        Assertions.assertThat(resultWinners.stream().map(Score::getName).toList()).containsSequence(expectWinners.stream().map(Score::getName).toList());
        Assertions.assertThat(resultWinners.stream().map(Score::getScore).toList()).containsSequence(expectWinners.stream().map(Score::getScore).toList());
    }

    @ParameterizedTest
    @MethodSource("우승자가_있는케이스")
    void 우승자를_나오게한다(String playerNames, List<Integer> points, List<String> expectWinnerName, List<Long> expectWinnerScore) {
        GameEngine gameEngine = new GameEngine(new ScoreUpdater(new RecursiveNumberGenerator(points)), new GameEngineValidator());
        gameEngine.initScore(playerNames);
        gameEngine.run();
        List<Score> resultWinners = gameEngine.getWinners();
        Assertions.assertThat(resultWinners.stream().map(Score::getName).toList()).containsExactlyElementsOf(expectWinnerName);
        Assertions.assertThat(resultWinners.stream().map(Score::getScore).toList()).containsExactlyElementsOf(expectWinnerScore);
    }

    @ParameterizedTest
    @MethodSource("점수가_그대로인_경우")
    void 숫자가_0_3까지는_전진하지않는다(int numberGeneratorReturnValue) {
        Long expect = 0L;
        GameEngine gameEngine = new GameEngine(new ScoreUpdater(new ReturnGenerator(numberGeneratorReturnValue)), new GameEngineValidator());
        gameEngine.initScore("");
        gameEngine.run();
        Assertions.assertThat(gameEngine.getWinners().get(0).getScore()).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("점수가_업데이트가_되는_경우")
    void 숫자가_4_9까지는_점수가오른다(int numberGeneratorReturnValue) {
        Long expect = 1L;
        GameEngine gameEngine = new GameEngine(new ScoreUpdater(new ReturnGenerator(numberGeneratorReturnValue)), new GameEngineValidator());
        gameEngine.initScore("");
        gameEngine.run();
        Assertions.assertThat(gameEngine.getWinners().get(0).getScore()).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("시도한_횟수값이_마이너스이거나_숫자가_아니거나_null_경우")
    void 시도한_횟수값이_마이너스이거나_숫자가_아니거나_null이면_예외를_던진다(String readLine) {
        GameEngine gameEngine = new GameEngine(new ScoreUpdater(new ReturnGenerator()), new GameEngineValidator());
        gameEngine.initScore("");
        Assertions.assertThatCode(() -> gameEngine.validatePlayCount(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }


}