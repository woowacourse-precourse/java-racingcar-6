package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceControllerTest {
    private static RaceController raceController;
    private static PrintStream standardOut;
    private static OutputStream captor;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        raceController = RaceController.getInstance(RaceService.getInstance());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        System.out.println(output());
        Console.close();
        raceController = null;
    }

    final String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("동일한 싱글톤 인스턴스를 보장합니다.")
    void getInstance() {
        // GIVEN
        RaceService service1 = RaceService.getInstance();
        RaceService service2 = RaceService.getInstance();

        // WHEN
        RaceController instance1 = RaceController.getInstance(service1);
        RaceController instance2 = RaceController.getInstance(service2);

        // THEN
        assertEquals(service1, service2);
        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("레이싱 게임을 검증합니다.")
    void startRaceGame() {
        final int MOVE_FORWARD = 4;
        final int STOP = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVE_FORWARD, STOP
        );
    }

    void run(final String... args) {
        try {
            command(args);
            raceController.startRaceGame();
        } finally {
            tearDown();
        }
    }

    void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}