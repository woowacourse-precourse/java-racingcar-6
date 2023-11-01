package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class InputViewTest {

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @Test
    void 이름이_5자_이하인_경우_올바르게_이름_목록으로_반환된다() {
        String input = "car1, car2, car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Car> cars = InputView.inputCarNames();

        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }

    @Test
    void 이름이_5자를_초과할_경우_IllegalArgumentException이_발생한다() {
        String input = "verylongname, car2, car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, InputView::inputCarNames);
    }

    @Test
    void 이름이_중복되는_경우_IllegalArgumentException이_발생한다() {
        String input = "car1, car2, car1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, InputView::inputCarNames);
    }

    @Test
    void 시도_횟수가_양의_정수인_경우_정상적으로_시도_횟수로_반환된다() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int attemptCount = InputView.inputAttemptCount();

        assertEquals(5, attemptCount);
    }

    @Test
    void 시도_횟수가_양의_정수가_아닌_경우_IllegalArgumentException이_발생한다() {
        String[] inputs = {"-1\n", "0\n", "abc\n"};

        for (String input : inputs) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            assertThrows(IllegalArgumentException.class, InputView::inputAttemptCount);
            Console.close();
        }
    }
}