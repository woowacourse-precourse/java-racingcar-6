package racingcar.domain.car.view;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import racingcar.domain.car.Car;
import racingcar.domain.util.OutputMessage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static racingcar.domain.util.OutputMessage.*;

class CarOutputViewTest {

    private CarOutputView carOutputView;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        carOutputView = new CarOutputView();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void clear() {
        output.reset();
    }


    @Nested
    @DisplayName("자동차 출력 테스트")
    class CarOutputTest {

        @Test
        @DisplayName("라운드 결과 메시지를 성공적으로 출력해야 한다")
        public void 라운드_결과_메시지를_성공적으로_출력해야_한다() {
            carOutputView.printResult();
            assertThat(output.toString().trim()).isEqualTo(PRINT_ROUND_RESULT.getMessage());
        }

        @Test
        @DisplayName("경기 진행 상황 메시지를 성공적으로 출력해야 한다")
        public void 경기_진행_상황_메시지를_성공적으로_출력해야_한다() {
            String expectResultMessage = "pobi : -woni : --\n";
            Car car = mock(Car.class);
            Car otherCar = mock(Car.class);

            when(car.toString()).thenReturn("pobi : -");
            when(otherCar.toString()).thenReturn("woni : --");

            carOutputView.printRoundResult(List.of(car, otherCar));

            assertThat(output.toString()).isEqualTo(expectResultMessage);
        }

        @Test
        @DisplayName("최종 우승자를 성공적으로 출력해야 한다")
        public void 최종_우승자를_성공적으로_출력해야_한다() {
            carOutputView.printWinner(List.of("pobi", "woni"));
            assertThat(output.toString()).isEqualTo(PRINT_FINAL_WINNER.getMessage() + "pobi, woni\n");
        }
    }
}
