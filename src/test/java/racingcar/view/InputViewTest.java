package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RoundCount;
import racingcar.domain.car.CarName;

@DisplayName("입력 테스트")
class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
        Console.close();
    }

    @DisplayName("자동차 이름 입력을 올바르게 처리한다")
    @Test
    void testReadCarNames() throws InterruptedException {

        String input = "pobi,jun,woni\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<CarName> carNames = inputView.readCarNames();
        assertEquals("pobi", carNames.get(0).toString());
        assertEquals("jun", carNames.get(1).toString());
        assertEquals("woni", carNames.get(2).toString());
    }

    @DisplayName("라운드 횟수 입력을 올바르게 처리한다")
    @Test
    void testReadNumberOfRounds() {
        String input = "5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        RoundCount numberOfRounds = inputView.readNumberOfRounds();
        for (int i = 0; i < 5; i++) {
            assertTrue(numberOfRounds.hasNextRound());
            numberOfRounds.consumeRound();
        }
        assertFalse(numberOfRounds.hasNextRound());
    }
}
