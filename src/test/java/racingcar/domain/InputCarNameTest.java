package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCarNameTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void testValidCarNames() {
        String input = "pobi,woni,jun\n"; // 유효한 자동차 이름을 입력
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 모의 입력 설정

        InputCarName inputCarName = new InputCarName();
        List<String> carNames = inputCarName.getCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void testInvalidCarName() {
        String input = "car1,Car2,car 3\n"; // 유효하지 않은 자동차 이름을 입력
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 모의 입력 설정
        InputCarName inputCarName = new InputCarName();

        assertThatThrownBy(() -> inputCarName.getCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testDuplicateCarNames() {
        String input = "car1,car2,car1\n"; // 중복된 자동차 이름을 입력
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 모의 입력 설정
        InputCarName inputCarName = new InputCarName();

        assertThatThrownBy(() -> inputCarName.getCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }
}