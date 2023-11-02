package racingcar.view.outputview;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

class SettingOutputViewTest {
    private static ByteArrayOutputStream outputMessage;
    private OutputView outputView = new SettingOutputView();

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("자동차 이름을 입력하세요를 출력한다.")
    void 자동차_이름_출력_테스트() {
        Map<String, Object> model = new HashMap<>();
        model.put("cars", null);
        outputView.display(model);
        Assertions.assertThat(outputMessage.toString()).contains("경주할 자동차 이름을 입력하세요");
    }

    @Test
    @DisplayName("시도할 회수는 몇회인가요?")
    void 시도_횟수_출력_테스트() {
        Map<String, Object> model = new HashMap<>();
        model.put("gameCount", null);
        outputView.display(model);
        Assertions.assertThat(outputMessage.toString()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("carNaems가 비어있지 않으면 gameCount를 출력한다.")
    void 시도_횟수_출력_테스트2() {
        Map<String, Object> model = new HashMap<>();
        model.put("cars", "notNull");
        model.put("gameCount", null);
        outputView.display(model);
        Assertions.assertThat(outputMessage.toString()).contains("시도할 회수는 몇회인가요?");
    }
}