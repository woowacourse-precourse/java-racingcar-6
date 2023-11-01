package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.service.GameService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class FunctionTest extends NsTest {
    @Test
    void 진행횟수_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).hasLineCount(8);
                },
                3, 4
        );
    }

    @Test
    void 우승자_1명_출력_메시지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,woo", "1");
                    assertThat(output())
                            .contains(
                                    "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
                                    , "시도할 회수는 몇회인가요?"
                                    , "실행 결과"
                                    , "kim : "
                                    , "woo : -"
                                    , "최종 우승자 : woo"
                            );
                },
                3, 4
        );
    }

    @Test
    void 우승자_2명_출력_메시지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kim,woo", "1");
                    assertThat(output())
                            .contains(
                                    "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
                                    , "시도할 회수는 몇회인가요?"
                                    , "실행 결과"
                                    , "kim : -"
                                    , "woo : -"
                                    , "최종 우승자 : kim, woo"
                            );
                },
                4, 4
        );
    }


    @Test
    void 전진_정지_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                1, 2
        );
    }

    @Test
    void 전진_정지_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("woo,kim", "1");
                    assertThat(output()).contains("woo : -", "kim : -", "최종 우승자 : woo, kim");
                },
                4, 4
        );
    }

    @Test
    void 전진_정지_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("woo,kim", "1");
                    assertThat(output()).contains("woo : ", "kim : -", "최종 우승자 : kim");
                },
                3, 4
        );
    }

    @Test
    void 전진_정지_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("woo,kim", "1");
                    assertThat(output()).contains("woo : -", "kim : ", "최종 우승자 : woo");
                },
                4, 3
        );
    }

    @Test
    void 자동차_이름_5글자_초과_오류_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woo,123456", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5글자_초과_오류_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef,kim", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_빈문자열_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_이중콤마_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_마지막_콤마_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,woo,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_문자열_입력_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,woo", "abcd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_최소값_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,woo", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_최소값_성공_테스트() {
        assertSimpleTest(() -> {
                run("kim,woo", "1");
                assertThat(output()).contains("kim : ");
            }
        );
    }

    @Test
    void 진행_횟수_최대값_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,woo", "101"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_최대값_성공_테스트() {
        assertSimpleTest(() -> {
                run("kim,woo", "100");
                assertThat(output()).contains("kim : ");
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
