package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.io.reader.Reader;
import racingcar.common.io.writer.Writer;

class RacingGameScreenTest {

    private final MockReader mockReader = new MockReader();
    private final MockWriter mockWriter = new MockWriter();
    private final RacingGameScreen racingGameScreen = new RacingGameScreen(mockReader, mockWriter);

    static class MockReader implements Reader {
        private String input;

        @Override
        public String readLine() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }
    }

    static class MockWriter implements Writer {
        private final ByteArrayOutputStream output = new ByteArrayOutputStream();

        @Override
        public void writeLine(String message) {
            new PrintStream(output).println(message);
        }

        public String getOutput() {
            return output.toString();
        }
    }

    @DisplayName("경주할 자동차 이름 입력 화면을 올바르게 구성하였는지 확인한다.")
    @Test
    void test_InputRacingScreen(){
        //given
        String input = "name1,name2";
        mockReader.setInput(input);

        //when
        String racerInput = racingGameScreen.inputRacer();

        //then
        String output = mockWriter.getOutput();
        assertThat(output).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        assertThat(racerInput).isEqualTo(input);
    }

    @DisplayName("시도 횟수 입력 화면을 올바르게 구성하였는지 확인한다.")
    @Test
    void test_InputNumberOfTurnsScreen(){
        //given
        String input = "10";
        mockReader.setInput(input);

        //when
        String racerInput = racingGameScreen.inputNumberOfTurns();

        //then
        String output = mockWriter.getOutput();
        assertThat(output).isEqualTo("시도할 횟수는 몇 회인가요?\n");
        assertThat(racerInput).isEqualTo(input);
    }

    @DisplayName("실행 결과 출력을 시작하는 화면을 올바르게 구성하였는지 확인한다.")
    @Test
    void test_StartShowGameResultScreen(){
        //given
        //when
        racingGameScreen.startShowGameResult();

        //then
        String output = mockWriter.getOutput();
        assertThat(output).isEqualTo("\n실행 결과\n");
    }
}