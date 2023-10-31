package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void beforeEach() {
        inputView = new InputView();
        Console.close(); // 테스트 한번 할 때마다, 자원을 새로 만든다.
    }

    @Test
    void test() {
        System.setIn(new ByteArrayInputStream("입력값".getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertEquals("입력값", scanner.nextLine());
    }

    @Test
    void requestCarNameFromUser_정상_입력() {
        System.setIn(new ByteArrayInputStream("Car1".getBytes()));
        String result = inputView.requestCarNameFromUser();
        assertEquals("Car1", result);
    }

    @Test
    void requestCarNameFromUser_아무것도_입력하지_않으면_예외() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        // 입력x 또는 공백만 입력한 경우 NoSuchElementException 을 캐치해서 IllegalArgumentException 이 발생해야 함
        assertThrows(IllegalArgumentException.class, () -> inputView.requestCarNameFromUser());
    }

    @Test
    void requestCarNameFromUser_공백만_입력한_경우_예외() {
        System.setIn(new ByteArrayInputStream("  ".getBytes()));

        assertThrows(IllegalArgumentException.class, () -> inputView.requestCarNameFromUser());
    }

    @Test
    void requestCarNameFromUser_맨앞_공백과_문자를_포함한_경우() {
        System.setIn(new ByteArrayInputStream(" pobi".getBytes()));
        String result = inputView.requestCarNameFromUser();
        Assertions.assertThat(" pobi").isEqualTo(result);
    }

    @Test
    void requestRacingRoundCountFromUser_정상_입력() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));

        String result = inputView.requestRacingRoundCountFromUser();
        assertEquals("5", result);
    }

    @Test
    void requestRacingRoundCountFromUser_아무것도_입력하지_않은_경우() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        assertThrows(IllegalArgumentException.class, () ->
                inputView.requestRacingRoundCountFromUser());
    }

    @Test
    void requestRacingRoundCountFromUser_공백만_입력한_경우_예외() {
        System.setIn(new ByteArrayInputStream("  ".getBytes()));

        assertThrows(IllegalArgumentException.class, () -> inputView.requestRacingRoundCountFromUser());
    }

    @Test
    void requestRacingRoundCountFromUser_공백과_숫자를_포함한_경우() {
        System.setIn(new ByteArrayInputStream(" 5 ".getBytes()));

        String result = inputView.requestRacingRoundCountFromUser();
        Assertions.assertThat("5").isEqualTo(result);
    }
}
