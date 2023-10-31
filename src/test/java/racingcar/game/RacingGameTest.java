package racingcar.game;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.result.RacingGameResult;

class RacingGameTest {

    @Test
    void 게임이_종료되면_결과를_반환한다() throws Exception {
        //given
        List<Car> cars = Stream.of("foo1", "foo2", "foo3").map(Car::new).toList();
        int attemptNumber = 5;
        int threshold = 4;
        String command = "-";
        NumberGenerator numberGenerator = (start, end) -> 5;

        RacingGame racingGame = RacingGame.of(cars, attemptNumber, threshold, command, numberGenerator);

        //when
        RacingGameResult racingGameResult = racingGame.process();

        //then
        Assertions.assertThat(racingGameResult).isNotNull();
    }

    @Test
    void 각_라운드에서_차가_움직인다() {
        //given
        List<Car> cars = Stream.of("foo1", "foo2", "foo3").map(Car::new).toList();
        int attemptNumber = 3;
        int threshold = 4;
        String command = "-";
        NumberGenerator numberGenerator = (start, end) -> 5;

        RacingGame racingGame = RacingGame.of(cars, attemptNumber, threshold, command, numberGenerator);

        //when
        racingGame.process();

        //then
        Assertions.assertThat(cars)
                .extracting("progress")
                .containsOnly(
                        "---",
                        "---",
                        "---"
                );
    }

    @Test
    void 각_라운드의_진행_상황이_출력된다() {
        //given
        List<Car> cars = List.of(new Car("foo1"), new Car("foo2"), new Car("foo3"));
        int attemptNumber = 3;
        int threshold = 4;
        String command = "-";
        NumberGenerator numberGenerator = (start, end) -> 5;

        RacingGame racingGame = RacingGame.of(cars, attemptNumber, threshold, command, numberGenerator);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //when
        racingGame.process();

        //then
        Assertions.assertThat(outContent.toString()).contains("foo1 : ---");
        Assertions.assertThat(outContent.toString()).contains("foo2 : ---");
        Assertions.assertThat(outContent.toString()).contains("foo3 : ---");

        //clean up
        System.setOut(System.out);
    }

}