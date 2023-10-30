package racingcar;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarGameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.OutputView;

public class OutputViewTest {

    @Test
    void 경주할_자동차_이름_입력_요청_출력_테스트() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printRequestCarNameMessage();

        String caputredOutput = outputStream.toString();
        Assertions.assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", caputredOutput);

    }

    @Test
    void 시도할_회수_입력_요청_출력_테스트() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printRequestTryNumberMessage();

        String caputredOutput = outputStream.toString();
        Assertions.assertEquals("시도할 회수는 몇회인가요?\n", caputredOutput);

    }


    @Test
    void 결과_시작_출력_테스트() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printResultStartMessage();

        String caputredOutput = outputStream.toString();
        Assertions.assertEquals("\n실행 결과\n", caputredOutput);

    }

    @Test
    void 게임_실행_결과_출력_테스트() {

        CarGameController carGameController = new CarGameController();
        List<String> carNames = new ArrayList<>();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        carNames.add("pobi");

        OutputView.printGameResultMessage(carGameController.createCars(carNames));
        String capturedOutput = outputStream.toString();

        Assertions.assertEquals("pobi : \n\n", capturedOutput);


    }

    @Test
    void 우승자_출력_테스트() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("jun");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputView.printFinalWinner(winners);

        String capturedOutput = outputStream.toString();

        Assertions.assertEquals("최종 우승자 : pobi, jun", capturedOutput);


    }


}
