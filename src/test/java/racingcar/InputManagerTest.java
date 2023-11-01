package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputManager;

class InputManagerTest {

    private InputManager inputManager = new InputManager();

    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 여러_문자열을_쉼표를_기준으로_나누어_저장() {
        // given
        String name1 = "pobi";
        String name2 = "woni";
        String name3 = "harry";
        List<String> names = List.of(name1, name2, name3);

        // when
        systemIn(String.join(",", name1, name2, name3));
        List<String> result = inputManager.getStringListSplitByComma();

        // then
        assertThat(result).isEqualTo(names);
    }

    @Test
    void 양의_정수를_입력받아_저장() {
        // given
        int number = 5;

        // when
        systemIn(String.valueOf(number));
        int result = inputManager.getOnePositiveNumber();
        assertThat(result).isEqualTo(number);
    }

    @Test
    void 양의_정수가_아닌_값을_입력받을_때_예외_발생() {
        // given
        systemIn("0");

        // when & then
        assertThatThrownBy(inputManager::getOnePositiveNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
