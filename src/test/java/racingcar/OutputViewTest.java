package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarGameController;
import racingcar.view.OutputView;

public class OutputViewTest {

    @Test
    void 경주할_자동차_이름_입력_요청_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printRequestCarNameMessage();

        String caputredOutput = outputStream.toString();
        assertThat(caputredOutput).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @Test
    void 시도할_회수_입력_요청_출력_테스트() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printRequestTryNumberMessage();

        String caputredOutput = outputStream.toString();
        assertThat(caputredOutput).isEqualTo("시도할 회수는 몇회인가요?\n");

    }


    @Test
    void 결과_시작_출력_테스트() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printResultStartMessage();

        String caputredOutput = outputStream.toString();
        assertThat(caputredOutput).isEqualTo("\n실행 결과\n");

    }

    @Test
    void 게임_실행_결과_출력_테스트() {

        CarGameController carGameController = new CarGameController();
        List<String> carNames = List.of("pobi");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printGameResultMessage(carGameController.createCars(carNames));
        String capturedOutput = outputStream.toString();

        assertThat(capturedOutput).isEqualTo("pobi : \n\n");

    }

    @Test
    void 우승자_출력_테스트() {
        List<String> winners = List.of("pobi", "jun");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printFinalWinner(winners);

        String capturedOutput = outputStream.toString();

        assertThat(capturedOutput).isEqualTo("최종 우승자 : pobi, jun");

    }

}
