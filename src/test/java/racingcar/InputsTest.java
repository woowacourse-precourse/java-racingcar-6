package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputsTest {
    Game game = new Game();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 자동차_이름_입력_테스트() {
        game.inputs = new Inputs();
        System.setIn(new ByteArrayInputStream("Car1,Car2,Car3".getBytes()));
        String userInput = game.inputs.askCarNames();
        assertEquals("Car1,Car2,Car3", userInput);
    }

    @Test
    void 자동차_이름들을_쉼표로_분리() {
        game.inputs = new Inputs();
        // 테스트 1: 쉼표로 구분된 자동차 이름들을 입력
        String carNames1 = "Car1,Car2,Car3";
        game.inputs.splitCarNames(carNames1);

        List<String> carNamesList1 = game.inputs.carNamesList;
        assertTrue(carNamesList1.contains("Car1"));
        assertTrue(carNamesList1.contains("Car2"));
        assertTrue(carNamesList1.contains("Car3"));

        // 테스트 2: 쉼표 없이 한 자동차 이름을 입력
        String carNames2 = "Car4";
        game.inputs.splitCarNames(carNames2);
        List<String> carNamesList2 = game.inputs.carNamesList;
        assertTrue(carNamesList2.contains("Car4"));

        // 테스트 3: 자동차 이름이 5글자 이상인 경우
        String carNames3 = "VeryLongCarName";
        assertThrows(IllegalArgumentException.class, () -> game.inputs.splitCarNames(carNames3));
    }

    @Test
    void 반복_숫자_테스트_자연수() {
        // 정상적으로 자연수를 입력한 경우
        game.inputs = new Inputs();
        System.setIn(new ByteArrayInputStream("5\n".getBytes())); // 개행 문자를 추가하여 엔터를 시뮬레이션
        game.inputs.askRaceNumbers();
        assertEquals(5, game.inputs.raceNumbers);


    }

    @Test
    void 반복_숫자_테스트_오류() {
        // 자연수가 아닌 값을 입력한 경우
        game.inputs = new Inputs();
        System.setIn(new ByteArrayInputStream("aaa\n".getBytes())); // 개행 문자를 추가하여 엔터를 시뮬레이션
        assertThatThrownBy(() -> game.inputs.askRaceNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비정상적인 값을 입력하셨습니다. 경주를 자동으로 종료합니다.");
    }
}