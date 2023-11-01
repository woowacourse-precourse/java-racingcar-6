package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String NEW_LINE = System.lineSeparator();

    private final PrintStream originalOutput = System.out;
    private OutputStream outputCaptor;
    private Game game;

    private void setInputs(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    private String getOutput() {
        return outputCaptor.toString();
    }

    private static String makeString(String... args) {
        StringBuilder output = new StringBuilder();
        for (String arg : args) {
            output.append(arg);
        }

        return output.toString();
    }

    @BeforeEach
    void testInit() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        game = new Game(new Cars(), new Rounds());
    }

    @AfterEach
    void testCleanUp() {
        System.setOut(originalOutput);
        Console.close();
    }

    @Test
    void 우승자가_한명일때_결과가_정상적으로_출력_되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    String expectedResult = 우승자가_한명일때_결과();
                    setInputs("pobi,woni", "1");

                    game.start();

                    assertThat(getOutput()).isEqualTo(expectedResult);
                },
                MOVING_FORWARD, STOP
        );
    }

    private String 우승자가_한명일때_결과() {
        return makeString(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", NEW_LINE
                , "시도할 회수는 몇회인가요?", NEW_LINE
                , "pobi : -", NEW_LINE
                , "woni : ", NEW_LINE
                , NEW_LINE
                , "최종 우승자 : pobi"
        );
    }

    @Test
    void 우승자가_세명일때_결과가_정상적으로_출력_되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    String expectedResult = 우승자가_세명일때_결과();
                    setInputs("pobi,woni,hong", "1");

                    game.start();

                    assertThat(getOutput()).isEqualTo(expectedResult);
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    private String 우승자가_세명일때_결과() {
        return makeString(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", NEW_LINE
                , "시도할 회수는 몇회인가요?", NEW_LINE
                , "pobi : -", NEW_LINE
                , "woni : -", NEW_LINE
                , "hong : -", NEW_LINE
                , NEW_LINE
                , "최종 우승자 : pobi, woni, hong"
        );
    }

    @Test
    void 라운드가_2개일때_정상적으로_출력_되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    String expectedResult = 라운드가_2개일때_결과();
                    setInputs("pobi,woni", "2");

                    game.start();

                    assertThat(getOutput()).isEqualTo(expectedResult);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    private String 라운드가_2개일때_결과() {
        return makeString(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", NEW_LINE
                , "시도할 회수는 몇회인가요?", NEW_LINE
                , "pobi : -", NEW_LINE
                , "woni : ", NEW_LINE
                , NEW_LINE
                , "pobi : --", NEW_LINE
                , "woni : -", NEW_LINE
                , NEW_LINE
                , "최종 우승자 : pobi"
        );
    }
}