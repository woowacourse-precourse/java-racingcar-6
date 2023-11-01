package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.service.RacingService;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RacingController 테스트")
class RacingControllerTest extends NsTest {
    private RacingController racingController;

    @BeforeEach
    void setUp() {
        racingController = new RacingController();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "\r", "\r\n"})
    void 초기_세팅_이름_공백_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woniay", "apoisa,goodad,jackas", "apois, goods, jacka"})
    void 초기_세팅_이름_길이_초과_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni", "apoi,good,jacka"})
    void 레이싱_초기_세팅_이름_정상_입력_테스트(String input) {
        assertSimpleTest(
                () -> {
                    runException(input);
                    assertThat(output()).contains("시도할 회수는 몇회인가요?");
                }
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}