package racingcar.output;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import racingcar.Application;
import racingcar.view.Print;

public class OutputTest extends NsTest {

    @TestFactory
    DynamicTest 메시지_출력() {
        return DynamicTest.dynamicTest("메시지 정상 출력 확인", () -> {
            Print print = new Print();
            print.message("메시지 정상 출력");
            Assertions.assertThat(output()).isEqualTo("메시지 정상 출력");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
