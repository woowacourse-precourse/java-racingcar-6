package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import view.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class OutputViewTest extends NsTest {

    @Test
    void 자동차_이름_입력_문구를_출력하는_기능_테스트() {
        assertSimpleTest(() -> {
            //when
            OutputView.printGetCarName();

            //then
            Assertions.assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        });
    }

    @Test
    void 경주_시도_횟수_입력_문구를_출력하는_기능_테스트() {
        assertSimpleTest(() -> {
            //when
            OutputView.printGetTryCount();

            //then
            Assertions.assertThat(output()).contains("시도할 회수는 몇회인가요?");
        });
    }



    @Override
    protected void runMain() {

    }
}
