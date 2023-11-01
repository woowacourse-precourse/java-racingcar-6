package racingcar.io.views;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.collaborator.race.Racer;
import racingcar.io.racing.RaceRandoms;
import racingcar.io.views.enums.RaceViewMessage;

class RaceViewTest {

    @AfterEach
    void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field field = Console.class.getDeclaredField("scanner");
        field.setAccessible(true);
        field.set(Scanner.class, null);
    }

    @Test
    void askRacersNames로_레이서리스트를_입력할수있음() {
        String testInput = "김길동,   김홍삼, 김말미잘";
        List<Racer> expected = Arrays.stream(testInput.split(","))
                .map(String::strip)
                .map(name -> new Racer(name, new RaceRandoms()))
                .toList();

        String input = enterInput(testInput);
        customSetIn(input);
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
        customSetIn(input);

        Assertions.assertThatThrownBy(() -> new RaceView().askRacersNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RaceViewMessage.EXCEPTION_DUPLICATE_NAME.get());
    }

    @Test
    void askRoundNumber로_회수를입력할수있음() {
        String testInput = "5";
        int expected = 5;

        String input = enterInput(testInput);
        customSetIn(input);
        Integer actual = new RaceView().askRoundNumber();

        assertThat(actual).isEqualTo(expected);
    }

    private static String enterInput(String testString) {
        return testString + "\n";
    }

    private static void customSetIn(String input) {
        InputStream customInput =
                new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
    }

}