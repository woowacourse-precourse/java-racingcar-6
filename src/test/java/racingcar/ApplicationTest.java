package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    Application app = new Application();

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 동시에_우승할경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름길이에_대한_예외_처리() {
        List<String> carNames = Arrays.asList("python, book, conn");
        assertThatThrownBy(() -> {
            app.checkInput(carNames);
        })
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 이름중복에_대한_예외_처리() {
        List<String> carNames = Arrays.asList("book", "var", "conn", "book", "book");
        assertThatThrownBy(() ->
                app.checkInput(carNames)
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름에_영문만_포함되었는지에_대한_예외_처리_한글입력시() {
        List<String> carNames = Arrays.asList("아ok", "var", "conn", "book");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> app.checkInput(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_영문만_포함되었는지에_대한_예외_처리_특수문자입력시() {
        List<String> carNames = Arrays.asList("아#$", "var", "conn", "book");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> app.checkInput(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("레이싱 카 이름이 영어로 이루어져 있지 않습니다.")
        );
    }
    @Test
    void 이름에_영문만_포함되었는지에_대한_예외_처리_숫자_포함시() {
        List<String> carNames = Arrays.asList("아1", "var", "conn", "book");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> app.checkInput(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("레이싱 카 이름이 영어로 이루어져 있지 않습니다.")
        );
    }
    @Test
    void 이름에_영문만_포함되었는지에_대한_예외_처리_이름에_공백이_포함될시() {
        List<String> carNames = Arrays.asList("아 ", "var", "conn", "book");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> app.checkInput(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("레이싱 카 이름이 영어로 이루어져 있지 않습니다.")
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
