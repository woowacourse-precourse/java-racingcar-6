package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Message;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.out.println(standardOut);
    }

    @DisplayName("콘솔에 인자로 들어온 메시지가 잘 출력되는지 확인")
    @Test
    void 차_이름_입력_요청_메시지_출력() {
        // given
        String message = Message.INPUT_CAR_NAME.getMessage();

        // when
        OutputView outputView = new OutputView();
        outputView.printMessage(message);

        assertThat(outputStream.toString()).isEqualTo(Message.INPUT_CAR_NAME.getMessage());
    }


}
