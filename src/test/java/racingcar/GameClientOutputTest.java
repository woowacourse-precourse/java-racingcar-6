package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameClientOutputTest {

    ByteArrayOutputStream outputStream;
    GameClientOutput gameClientOutput = new GameClientOutput();

    @BeforeEach
    public void setupOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("우승자를 올바르게 출력한다.")
    public void printWinners(){
        List<String> winners = List.of("abc", "def", "ghi");
        gameClientOutput.printWinners(winners);
        String printedString = outputStream.toString().trim();

        assertThat(printedString).isEqualTo("최종 우승자 : abc, def, ghi");
    }
}