package racingcar.view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InputViewTest {

    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    public void setUpInput() {
        String inputForTest = "pobi,woni,jun\n5\n";
        ByteArrayInputStream testInStream = new ByteArrayInputStream(inputForTest.getBytes());
        System.setIn(testInStream);
    }

    @AfterEach
    public void restoreInput() {
        System.setIn(originalSystemIn);
    }

    @Order(1)
    @Test
    public void 자동차_이름_입력() throws Exception {
        // given
        String expectedCarNames = "pobi,woni,jun";

        // when
        String actualCarNames = InputView.getCarNamesFromUser();

        // then
        assertEquals(expectedCarNames, actualCarNames);
    }

    @Order(2)
    @Test
    public void 게밍_시도_횟수_입력() throws Exception {
        //given
        int expectedAttemptCount = 5;

        //when
        int actualAttemptCount = InputView.getAttemptCountFromUser();

        //then
        assertEquals(expectedAttemptCount, actualAttemptCount);
    }

}