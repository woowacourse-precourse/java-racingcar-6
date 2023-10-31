package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.view.OutputView.*;

class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @Test
    void 차_이름_입력요청_메시지_출력_테스트() {
        OutputView.printCarNameRequest();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(CAR_NAME_REQUEST_MESSAGE);
    }


    @Test
    void 시도횟수_입력요청_메시지_출력_테스트() {
        OutputView.printAttemptCountRequest();
        Assertions.assertThat(outputStream.toString().trim()).contains(ATTEMPT_COUNT_REQUEST_MESSAGE);
    }

}