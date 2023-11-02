package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarPark;
import racingcar.service.impl.InputConvertServiceImpl;
import racingcar.service.impl.ValidateServiceImpl;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
    void 이름이_숫자일때_전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("1,2", "1");
                    assertThat(output()).contains("1 : -", "2 : ", "최종 우승자 : 1");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 전진_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 마지막_글자가_쉼표_일때_예외_처리() {
        String input = "kyh,";
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        InputConvertServiceImpl inputConvertService = new InputConvertServiceImpl(validateService);

        Assertions.assertThatThrownBy(() -> inputConvertService.inputConvertCarPark(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Car_이름_제대로_들어갔는지_체크() {
        String input = "cbnu,math,eng";
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        InputConvertServiceImpl inputConvertService = new InputConvertServiceImpl(validateService);
        CarPark carPark = inputConvertService.inputConvertCarPark(input);

        List<String> nameList = carPark.makeNameList();
        assertThat(nameList).contains("cbnu", "math", "eng");
        assertThat(nameList).containsExactly("cbnu", "math", "eng");
    }

    @Test
    void 횟수_숫자가_아닌_문자가_입력될떄_예외_처리() {
        String input = "s";
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        InputConvertServiceImpl inputConvertService = new InputConvertServiceImpl(validateService);

        Assertions.assertThatThrownBy(() -> inputConvertService.inputConvertRoundCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
