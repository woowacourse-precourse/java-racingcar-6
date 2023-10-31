package racingcar.input;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import racingcar.Application;
import racingcar.view.Input;

public class InputTest extends NsTest {

    @TestFactory
    Collection<DynamicTest> 자동차_이름_정상_입력() {
        command("pobi,woni,jun", "5");
        return List.of(
                DynamicTest.dynamicTest("정상 입력 확인", () -> {
                    Input input = new Input();
                    String carNames = input.carNames();
                    Assertions.assertThat("pobi,woni,jun").isEqualTo(carNames);
                }),

                DynamicTest.dynamicTest("정상 입력 확인", () -> {
                    Input input = new Input();
                    String tryCount = input.tryCount();
                    Assertions.assertThat("5").isEqualTo(tryCount);
                })
        );
    }

    private void command(final String... args) {
        final byte[] bytes = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(bytes));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
