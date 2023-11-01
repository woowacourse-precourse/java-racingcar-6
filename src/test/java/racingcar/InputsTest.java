package racingcar;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputsTest {
    Game game = new Game();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    InputStream originalSystemIn = System.in; // System.in 백업


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

//    @Test
//    void 자동차_이름_입력_테스트() {
//        game.inputs = new Inputs();
//        System.setIn(new ByteArrayInputStream("Car1,Car2,Car3".getBytes()));
//        String userInput = game.inputs.askCarNames();
//        assertEquals("Car1,Car2,Car3", userInput);
//    }

    @Test
    void 자동차_이름들을_쉼표로_분리() {
        game.inputs = new Inputs();

        // 1. 자동차 이름이 1개인 경우
        String carName = "자동차1";
        game.inputs.carNamesList.clear();
        game.inputs.splitCarNames(carName);
        assertThat(game.inputs.carNamesList).containsExactly(carName);

        // 2. 자동차 이름이 여러개인 경우
        String carNames = "자동차1,자동차2,자동차3";
        game.inputs.carNamesList.clear();
        game.inputs.splitCarNames(carNames);
        assertThat(game.inputs.carNamesList).containsExactly("자동차1", "자동차2", "자동차3");

        // 3. 자동차 이름이 5글자를 넘는 경우
        String tooLongCarName = "자동차이름5글자이상";
        game.inputs.carNamesList.clear();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> game.inputs.splitCarNames(tooLongCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비정상적인 값을 입력하셨습니다. 경주를 자동으로 종료합니다."));

        // 4. 자동차 이름이 5글자를 넘고 쉼표로 구분된 경우
        String tooLongCarNames = "자동차이름5글자이상,자동차1";
        game.inputs.carNamesList.clear();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> game.inputs.splitCarNames(tooLongCarNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비정상적인 값을 입력하셨습니다. 경주를 자동으로 종료합니다."));

        // 5. 콤마 이후에 공백이 있는 경우
        String carNameWithSpace = "자동차1, 자동차2";
        game.inputs.carNamesList.clear();
        game.inputs.splitCarNames(carNameWithSpace);
        assertThat(game.inputs.carNamesList).containsExactly("자동차1", " 자동차2");
    }

//    @Test
//    void 반복_숫자_테스트_자연수() {// 정상적으로 자연수를 입력한 경우
//        game.inputs = new Inputs();
//        ByteArrayInputStream inputStream = new ByteArrayInputStream("5\n".getBytes()); // 사용자 입력을 시뮬레이션할 스트림
//        System.setIn(inputStream); // 개행 문자를 추가하여 엔터를 시뮬레이션
//        String a = camp.nextstep.edu.missionutils.Console.readLine();
//        System.out.println(a);
//        game.inputs.askRaceNumbers();
//        assertEquals(5, game.inputs.raceNumbers);
//    }

    @Test
    void 반복_숫자_테스트_오류() { // 자연수가 아닌 값을 입력한 경우
        game.inputs = new Inputs();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("aaa\n".getBytes()); // 사용자 입력을 시뮬레이션할 스트림
        System.setIn(inputStream); // 개행 문자를 추가하여 엔터를 시뮬레이션
        assertThatThrownBy(() -> game.inputs.askRaceNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비정상적인 값을 입력하셨습니다. 경주를 자동으로 종료합니다.");
    }
}