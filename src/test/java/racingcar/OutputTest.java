package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.Output;

public class OutputTest extends NsTest {

    @Test
    @DisplayName("게임 진행 결과 출력 테스트")
    void printGameProgress_test(){
        Car car1 = new Car("pobi", 1);
        Car car2 = new Car("woni", 2);
        List<Car> carListForTest = List.of(car1, car2);

        Output.printGameProgress(carListForTest);

        assertThat(output()).contains("pobi : -", "woni : --");
    }

    @Override
    protected void runMain() {
    }
}
