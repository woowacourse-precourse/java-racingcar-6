package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.ResultDto;
import racingcar.service.RacingService;
import racingcar.util.Sentence;
import racingcar.util.TestConsts;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    public static final String ROUND_USER_INPUTTED = "1";
    OutputView outputView = new OutputView();
    private OutputStream captor;

    @BeforeEach
    @DisplayName("Test 내부에서 콘솔 출력값을 검증하기 위해 세팅한 메서드(NsTest 참고)")
     void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    private final String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) 출력 확인")
    void beforeInputCarNames() {
        outputView.beforeInputCarNames();
        assertThat(output())
                .contains(Sentence.INPUT_CAR_NAMES.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수는 몇회인가요? 출력 확인")
    void beforeInputTryNumber() {
        outputView.beforeInputTryNumber();
        assertThat(output())
                .contains(Sentence.INPUT_TRY_NUMBERS.getMessage());
    }

    @Test
    void printResult() {
        CarsDto carsDto = new CarsDto("pobi,woni,jun");
        Client client = new Client(ROUND_USER_INPUTTED);
        RacingService racingService = new RacingService(carsDto, client);
        assertRandomNumberInRangeTest(
                () -> {
                    ResultDto resultDto = racingService.playCarRacing();
                    outputView.printResult(resultDto);
                    assertThat(output()).contains("실행 결과", "pobi : ", "woni : ", "jun : -", "최종 우승자 : jun");
                }, TestConsts.STOP, TestConsts.STOP, TestConsts.MOVE_FORWARD
        );
    }
}