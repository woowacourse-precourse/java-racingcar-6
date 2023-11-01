package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.OutPutView.*;

class OutPutViewTest {
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut; // 표준 스트림

    @BeforeEach
    void setUp() {
        standardOut = System.out; // 표준 스트림 초기화
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor)); // sysout 된거 열로 집어 삼킴
    }

    @AfterEach
    protected void printResult() {
        System.setOut(standardOut); // 표준 스트림 할당
        System.out.println(getOutput()); // 원하는 내용이 잘 나왔는지 문자열 디코딩 바이트를 가져와 출력
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

    OutPutView outPutView = new OutPutView();

    @Test
    void startMention() {
        outPutView.startMention();
        assertThat(getOutput()).contains(START_METION);
    }

    @Test
    void tryCount() {
        outPutView.tryCount();
        assertThat(getOutput()).contains(ASK_TRY_COUNT);
    }

    @Test
    void executeResult() {
        Cars cars = new Cars();
        cars.setCarsData(List.of("a", "b"));

        outPutView.executeResult(cars);
        assertThat(getOutput()).contains(EXECUTE_RESULT + "\na : \nb : ");
    }

    @Test
    void winner() {
        outPutView.winner("winner");
        assertThat(getOutput()).contains(WINNER_TEMPLATE + COLON + "winner");
    }
}