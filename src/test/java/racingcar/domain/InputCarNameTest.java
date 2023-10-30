package racingcar.domain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCarNameTest {
    private InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        // 테스트 전에 System.in을 백업하고 모의 입력을 설정
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        // 테스트 후에 원래의 System.in을 복원
        System.setIn(originalSystemIn);
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