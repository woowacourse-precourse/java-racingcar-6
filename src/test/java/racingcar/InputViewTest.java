package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.input.InputView;

public class InputViewTest extends NsTest {

    private final String INPUT_CAR_NAMES = "woni,pobi,jun";
    private final String INPUT_TRY_COUNT = "1";

    @Test
    void Console_readLine_활용하여_N대_자동차_및_시도횟수_입력() {
        assertSimpleTest(() -> {
            try (final MockedStatic<Console> mock = mockStatic(Console.class)) {
                mock.when(() -> Console.readLine()).thenReturn(INPUT_CAR_NAMES, INPUT_TRY_COUNT);
                run(INPUT_CAR_NAMES, INPUT_TRY_COUNT);
                assertThat(output()).contains("woni", "pobi", "jun", "1");
                mock.verify(() -> Console.readLine(),times(2));
            }
        });
    }

    @Override
    protected void runMain() {
        String carsName = InputView.inputCarsName();
        String tryCount = InputView.inputTryCount();
        System.out.println(carsName);
        System.out.println(tryCount);
    }
}
