package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.service.RacingService;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RacingController 테스트")
class RacingControllerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private RacingController racingController;

    @BeforeEach
    void setUp() {
        racingController = new RacingController();
    }

    @AfterEach
    void end() {
        racingController.cleanUp();
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

    @ParameterizedTest
    @ValueSource(strings = {"#", "!", "%", "&"})
    void 횟수_특수문자_입력_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "\r", "\r\n", "-1"})
    void 횟수_입력_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 횟수_정상_입력__테스트(String input) {
        assertSimpleTest(
                () -> {
                    runException("pobi", input);
                    assertThat(output()).contains("실행 결과");
                }
        );
    }

    @Test
    void 전체_진행_단일_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,jack", "1");
                    assertThat(output()).contains("kim : -", "jack : ", "최종 우승자 : kim");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 전체_진행_횟수_0_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,jack", "0");
                    assertThat(output()).contains("최종 우승자 : kim, jack");
                },
                STOP, STOP
        );
    }

    @Test
    void 전체_진행_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,jack", "2");
                    assertThat(output()).contains("kim : --", "jack : ", "최종 우승자 : kim");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}