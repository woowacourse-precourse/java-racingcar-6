package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;
import racingcar.service.RacingcarServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ExampleInputTest {

    private final static RacingcarController racingcarController = new RacingcarController();
    private final static RacingcarService racingcarService = new RacingcarServiceImpl();

    @Test
    void 기본_실행_동작_테스트() {
        racingcarService.initStore();
        racingcarService.joinRacingcar("test,1234,+~!_,한글");
        racingcarController.testProcess(10);
        assertThat(racingcarController.outputWinners()).isEqualTo(true);
    }

    @Test
    void 띄어쓰기로_시작하는_이름() {
        assertThatThrownBy(() -> {
            String name = " a1";
            racingcarService.joinRacingcar(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 줄바꿈이_들어간_이름() {
        assertThatThrownBy(() -> {
            String name = "a\n2";
            racingcarService.joinRacingcar(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}