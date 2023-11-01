package racingcar.io.views;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.ConsoleTestSuper;
import racingcar.collaborator.race.Racer;
import racingcar.io.racing.RaceRandoms;
import racingcar.io.views.enums.RaceViewMessage;

class RaceViewTest extends ConsoleTestSuper {

    @Test
    void askRacersNames로_레이서리스트를_입력할수있음() {
        String testInput = "김길동,   김홍삼, 김말미잘";
        List<Racer> expected = Arrays.stream(testInput.split(","))
                .map(String::strip)
                .map(name -> new Racer(name, new RaceRandoms()))
                .toList();

        String input = enterInput(testInput);
        setIn(input);
        List<Racer> actual = new RaceView().askRacersNames();

        assertThat(actual.size()).isEqualTo(expected.size());
        String actualCollect = actual.stream()
                .map(Racer::getName)
                .collect(Collectors.joining(","));
        String expectedCollect = expected.stream()
                .map(Racer::getName)
                .collect(Collectors.joining(","));
        assertThat(actualCollect).isEqualTo(expectedCollect);
    }

    @Test
    void askRacersNames로_중복된레이서리스트를입력하면_예외처리() {
        String testInput = "김홍삼,   김홍삼, 김홍삼";

        String input = enterInput(testInput);
        setIn(input);

        assertThatThrownBy(() -> new RaceView().askRacersNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RaceViewMessage.EXCEPTION_DUPLICATE_NAME.get());
    }

    @Test
    void askRoundNumber로_회수를입력할수있음() {
        String testInput = "5";
        int expected = Integer.parseInt(testInput);

        String input = enterInput(testInput);
        setIn(input);
        Integer actual = new RaceView().askRoundNumber();

        assertThat(actual).isEqualTo(expected);
    }

}