package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void carName_입력() {
        assertThat(MockInput.inputCarName("pobi1,pobi2,pobi3"))
                .isEqualTo(List.of("pobi1", "pobi2", "pobi3"));

    }

    @Test
    void moveChance_입력() {
        assertThat(MockInput.inputMoveChance("1")).isEqualTo(1);
    }

    public static class MockInput {
        public static List<String> inputCarName(String name) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            return Mapper.changeToListString(name);
        }

        public static int inputMoveChance(String number) {
            System.out.println("시도할 회수는 몇회인가요?");
            return Mapper.changeToInteger(number);
        }

    }

}