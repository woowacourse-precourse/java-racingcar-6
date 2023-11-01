package racingcar.Test;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ServiceMessage;
import racingcar.output.ServicePrinter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ServicePrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ServicePrinter servicePrinter = new ServicePrinter();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("시작 메시지가 정상적으로 출력된다.")
    void 시작_메시지_출력() {
        servicePrinter.printStartMessage();
        assertThat(outContent.toString()).isEqualTo(ServiceMessage.START.serviceMessage);
    }

    @Test
    @DisplayName("입력 메시지가 정상적으로 출력된다.")
    void 입력_메시지_출력() {
        servicePrinter.printInputMessage();
        assertThat(outContent.toString()).isEqualTo(ServiceMessage.INPUT.serviceMessage);
    }

    @Test
    @DisplayName("출력 메시지가 정상적으로 출력된다.")
    void 출력_메시지_출력() {
        servicePrinter.printOutputMessage();
        assertThat(outContent.toString()).isEqualTo(ServiceMessage.OUTPUT.serviceMessage);
    }

    @Test
    @DisplayName("우승자 메시지가 정상적으로 출력된다.")
    void 우승자_메시지_출력() {
        List<String> winners = Arrays.asList("name1", "name2");
        servicePrinter.printWinnerMessage(winners);
        assertThat(outContent.toString()).isEqualTo(ServiceMessage.WINNER.serviceMessage + String.join(", ", winners));
    }

    @Test
    @DisplayName("레이스 상태가 정상적으로 출력된다.")
    void 레이스_상태_출력() {
        String[] names = {"car1", "car2"};
        int[] countsByName = {3, 5};
        ServicePrinter.printRaceStatus(names, countsByName);
        assertThat(outContent.toString()).isEqualTo("car1 : ---\ncar2 : -----\n\n");
    }
}
