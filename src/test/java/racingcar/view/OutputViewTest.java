package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {
    private static ByteArrayOutputStream console;

    @BeforeEach
    void streamSetup() {
        console = new ByteArrayOutputStream();
        System.setOut(new PrintStream(console));
    }

    @AfterEach
    void streamRestore() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("names 리스트의 이름들을 콤마를 구분자로 하여 알맞게 출력하는지")
    public void printFinalWinnerTest() {
        List<String> names = new ArrayList<>();
        names.add("poky");
        names.add("pobi");
        names.add("jun");

        OutputView.printFinalWinner(names);

        assertThat(console.toString())
                .contains("최종 우승자 : poky, pobi, jun");
    }

    @Test
    @DisplayName("인자로 받은 moved의 횟수만큼 '-'를 반복하여 형식에 맞게 출력하는지")
    public void printResult() {
        OutputView.printResult("poky", 4);

        assertThat(console.toString())
                .contains("poky : ----");
    }
}
