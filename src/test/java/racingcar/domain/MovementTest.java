package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MovementTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    Movement movement = new Movement();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 이름_리스트_크기의_움직임_리스트_생성() {
        // given
        List<String> names = Arrays.asList("aaa", "bbb", "ccc");

        // when
        List<Integer> movementList = movement.createMovement(names);

        // then
        assertThat(movementList).containsExactly(0, 0, 0);
        assertThat(movementList.size()).isEqualTo(3);
    }

    @Test
    void 랜덤값_4_초과면_한칸_움직임() {
        // given
        int movementIndex = 5;
        int random = 7;

        // when
        int moveOrStop = movement.raceMoveOrStop(movementIndex, random);

        // then
        assertThat(moveOrStop).isEqualTo(6);
    }

    @Test
    void 랜덤값_4_이하면_멈춤() {
        // given
        int movementIndex = 5;
        int random = 2;

        // when
        int moveOrStop = movement.raceMoveOrStop(movementIndex, random);

        // then
        assertThat(moveOrStop).isEqualTo(5);
    }

    @Test
    void 한_사이클_실행_프린트() {
        // given
        List<String> names = Arrays.asList("aaa", "bbb", "ccc");
        List<Integer> movementList = Arrays.asList(4, 3, 6);

        // when
        movement.printRace(names, movementList);
        String expectedPrintRaceFormat = "aaa : ----\nbbb : ---\nccc : ------\n\n";

        // then
        assertThat(output.toString()).isEqualTo(expectedPrintRaceFormat);
    }
}