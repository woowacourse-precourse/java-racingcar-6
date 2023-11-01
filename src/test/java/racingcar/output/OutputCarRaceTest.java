package racingcar.output;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static java.lang.String.format;

import org.junit.jupiter.api.Test;
import racingcar.output.MessageTypeTest.MessageType;

public class OutputCarRaceTest extends PrintTest {
    private static final String 차이름 = "차이름";
    private static final String 차이름들 = "pobi1,pobi2,pobi3,pobi4";

    public static class OutputCarRace {
        private OutputCarRace() {
        }

        public static void print(final MessageType messageType) {
            printMessage(messageType.getValue());
        }

        public static void printf(final MessageType messageType, final Object... inputNames) {
            printMessage(format(messageType.getValue(), inputNames));
        }

        private static void printMessage(String message) {
            System.out.print(message);
        }
    }

    @Test
    void 자동차_이름입력멘트_출력_정상() {
        OutputCarRace.print(MessageType.INPUT_CAR_NAME_PRINT);

        assertThat(output()).contains(MessageType.INPUT_CAR_NAME_PRINT.getValue());
    }

    @Test
    void 자동차_경주회수_출력_정상() {
        OutputCarRace.print(MessageType.INPUT_CAR_RACING_COUNT_PRINT);

        assertThat(output()).contains(MessageType.INPUT_CAR_RACING_COUNT_PRINT.getValue());
    }

    @Test
    void 자동차_경주_실행결과_정상() {
        OutputCarRace.print(MessageType.OUTPUT_RACE_START_PRINT);

        assertThat(output()).contains(MessageType.OUTPUT_RACE_START_PRINT.getValue());
    }

    @Test
    void 자동차_이름들_출력_정상() {
        String format = format(MessageType.OUTPUT_IMPLEMENTATION_RESULT_PRINT.getValue(), 차이름, "");
        OutputCarRace.printf(MessageType.OUTPUT_IMPLEMENTATION_RESULT_PRINT, 차이름, "");

        assertThat(outputf(차이름)).contains(format);
    }

    @Test
    void 입력했던_값_출력() {
        String format = format(MessageType.INPUT_DATA_PRINT.getValue(), 차이름들);
        OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, 차이름들);

        assertThat(outputf(차이름들)).contains(format);
    }

    @Test
    void 우승자_값_출력() {
        String format = format(MessageType.OUTPUT_WINNERS_PRINT.getValue(), 차이름들);
        OutputCarRace.printf(MessageType.OUTPUT_WINNERS_PRINT, 차이름들);

        assertThat(outputf(차이름들)).contains(format);
    }
}
