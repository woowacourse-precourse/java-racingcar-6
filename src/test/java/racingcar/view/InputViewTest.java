package racingcar.view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InputViewTest {

    private final InputStream systemIn = System.in;

    @BeforeEach
    public void setUpInput() {
        String input = "pobi,woni,jun\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @AfterEach
    public void restoreInput() {
        System.setIn(systemIn);
    }

    @Order(1)
    @Test
    public void 자동차_이름_입력() throws Exception {
        // given
        String expected = "pobi,woni,jun";

        // when
        String actual = InputView.getCarNamesFromUser();

        // then
        assertEquals(expected, actual, "Input does not match expected car names!!!");
    }

    @Order(2)
    @Test
    public void 게밍_시도_횟수_입력() throws Exception {
        //given
        int expected = 5;

        //when
        int actual = InputView.getAttemptCountFromUser();

        //then
        assertEquals(expected, actual, "Input does not match expected attempts!!!");
    }

}