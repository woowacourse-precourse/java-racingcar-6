package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.model.Car;
import racingcar.model.RacingCarGame;

class RacingCarGameViewTest {

    @Mock
    private RacingCarGame game = mock(RacingCarGame.class);
    private final RacingCarGameView gameView
            = new RacingCarGameView("src/main/resources/messages/racing-car-game-messages.properties");
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @Test
    void 입력필요메시지출력() {
        gameView.showInputRequiredMessage();
        assertThat(output())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 횟수입력필요메시지출력() {
        gameView.showRepeatingNumberRequiredMessage();
        assertThat(output()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    void 게임진행상황출력() {
        Car car = new Car("test");
        car.move();
        given(game.getCarList()).willReturn(Arrays.asList(car));
        gameView.showProgressOf(game);
        assertThat(output()).isEqualTo("test : -");
    }

    @Test
    void 게임결과메시지출력() {
        given(game.getWinners()).willReturn(Arrays.asList("황인태", "홍길동"));
        gameView.showResultOf(game);
        assertThat(output()).isEqualTo("최종 우승자 : 황인태, 홍길동");
    }

    @Test
    void 실행결과메시지출력() {
        gameView.showResultMessage();
        assertThat(output()).isEqualTo("실행 결과");
    }

    String output() {
        return outputMessage.toString().trim();
    }
}