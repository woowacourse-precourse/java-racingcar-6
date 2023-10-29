package racingcar.domain.car.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.util.OutputMessage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarOutputViewTest {

    @Nested
    @DisplayName("자동차 출력 테스트")
    class CarOutputTest {

        @Test
        @DisplayName("라운드 결과 메시지를 성공적으로 출력해야 한다")
        public void 라운드_결과_메시지를_성공적으로_출력해야_한다() {
            CarOutputView carOutputView = new CarOutputView();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            carOutputView.printResult();
            assertThat(output.toString().trim()).isEqualTo(OutputMessage.PRINT_ROUND_RESULT.getMessage());

            output.reset();
        }
    }


}
