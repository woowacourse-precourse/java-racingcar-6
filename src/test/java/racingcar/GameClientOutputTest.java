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

    @Test
    @DisplayName("횟수를 묻는 안내 문구를 정확하게 출력한다.")
    public void printMove(){
        gameClientOutput.printForAskingMoves();
        String printedString = outputStream.toString().trim();
        assertThat(printedString).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("이름을 입력하는 안내 문구를 정확하게 출력한다.")
    public void printName(){
        gameClientOutput.printForAskingNames();
        String printedString = outputStream.toString().trim();
        assertThat(printedString).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("실행 결과 문구를 정확하게 출력한다.")
    public void printResultMessage(){
        gameClientOutput.printResultMessage();
        String printedString = outputStream.toString().trim();
        assertThat(printedString).isEqualTo("실행 결과");
    }
}