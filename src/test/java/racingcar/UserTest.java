package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    public void setUpInput() {
        // 테스트 전에 원래의 System.in을 저장하고 사용자 입력을 재지정
        String input = "pobi,MJ,tjwls";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    public void restoreSystemIn() {
        // 테스트 후에 원래의 System.in을 복원
        System.setIn(originalSystemIn);
    }

    @Test
    public void 경주할_자동차를_입력하라() {
        User user = new User();
        String carName = user.inputCarName();
        assertEquals("pobi,MJ,tjwls", carName);
    }
}
