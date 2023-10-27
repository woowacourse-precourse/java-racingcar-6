package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class IOTest {
    private IO io;

    @BeforeEach
    void setUp() {
        io = new IO();
    }

    @Test
    void inputCarNames_정상_작동() {
        String input = "a,b,c";
        provideInput(input);

        String[] nameArr = io.inputCarNames();

        assertThat(nameArr).containsExactly("a", "b", "c");
    }

    @Test
    void inputCarNames_앞에_쉼표_발견() {
        String input = ",b,c";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @Test
    void inputCarNames_뒤에_쉼표_발견() {
        String input = "a,b,";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @Test
    void inputNumberOfAttempts_정상_작동() {
        String input = "6";
        provideInput(input);

        int number = io.inputNumberOfAttempts();

        assertThat(number).isEqualTo(6);
    }

    @Test
    void inputNumberOfAttempts_입력_안함() {
        String input = "";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @Test
    void inputNumberOfAttempts_숫자가_아닌_경우() {
        String input = "a";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @Test
    void outputRacingStatus() {
        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("pobi", 3);
        nameMap.put("woni", 2);
        nameMap.put("jun", 4);

        String[] nameArr = {"pobi", "woni", "jun"};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        io.outputRacingStatus(nameArr, nameMap);

        String expectedOutput = "pobi : ---\n" + "woni : --\n" + "jun : ----\n\n";

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void outputResult() {
        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("pobi", 3);
        nameMap.put("woni", 3);
        nameMap.put("jun", 2);

        String[] nameArr = {"pobi", "woni", "jun"};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        io.outputResult(3, nameArr, nameMap);

        String expectedOutput = "최종 우승자 : pobi, woni\n";

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @AfterEach
    void 테스트종료() {
        Console.close();
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}